package com.tekcamp.program;

import com.tekcamp.environment.MapLevel;
import com.tekcamp.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main extends Canvas implements Runnable, KeyListener {

    private boolean isRunning = false; // check if thread is running
    public static final int WIN_WIDTH = 608; // window width
    public static final int WIN_HEIGHT = 736; // window height
    public static final String title = "Pac Man"; 

    private Thread thread;

    public static PacMan pacMan;
    public static List<Creature> ghosts;
    public static MapLevel mapLevel;
    public static List<Coin> coins;

    public Main() {
        Dimension dimension = new Dimension(Main.WIN_WIDTH, Main.WIN_HEIGHT);
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);

        addKeyListener(this);
        pacMan = new PacMan(0, 0);
        ghosts = Arrays.asList(new Ghost(0, 0), new Ghost(0, 0), new Ghost(0, 0));
        mapLevel = new MapLevel("/map1.png");
        coins = MapLevel.getCoins();
    }

    public synchronized void start() {
        if (isRunning) {
            return;
        }
        isRunning = true;
        thread = new Thread(this);
		
        thread.start();


    }

    public synchronized void stop() {
        if (!isRunning) {
            return;
        }
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void tick() {
        pacMan.move();

        for (int i = 0; i < coins.size(); i++) {
            if (pacMan.eatCoin(coins.get(i))) {
                coins.remove(i);
                break;
            }
        }

        if (coins.size() == 0) {
            //render win text to screen
            System.out.println("Congrats you won the game!");
            System.exit(0);
        }

        for (Creature ghost : ghosts) {
            ghost.eatCreature(pacMan);
        }
    }

    private void render() {
        BufferStrategy bufferStrategy = getBufferStrategy();

        // initializes bufferStrategy for first render call
        if (bufferStrategy == null) {
            createBufferStrategy(3);
            return;
        }
        // after having a bufferStrategy we can create graphics object using
        // bufferStrategy
        Graphics g = bufferStrategy.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, Main.WIN_WIDTH, Main.WIN_HEIGHT);
        pacMan.render(g);
        for (Creature ghost : ghosts) {
            ghost.render(g);
        }
        mapLevel.render(g);
        g.dispose();
        bufferStrategy.show();
    }

    @Override
    public void run() {
        requestFocus(); // allows our key press to be tied to the game window
        int fps = 0;
        double timer = System.currentTimeMillis();
        long lastTime = System.nanoTime();
        double targetFPSTick = 60.0;
        double delta = 0;
        double nanoseconds = 1000000000 / targetFPSTick;

        while (isRunning) {
            long nowTime = System.nanoTime();
            delta += (nowTime - lastTime) / nanoseconds;
            lastTime = nowTime;

            while (delta >= 1) {
                tick();
                render();
                fps++;
                delta--;
            }

            if (System.currentTimeMillis() - timer >= 1000) {
                fps = 0;
                timer += 1000;
            }
        }

        stop();

    }

    public static void main(String[] args) {
        boolean willPlayGame = false;
        // Greeting prompt and instructions
        System.out.println("Welcome to my version of the classic Pac Man game");
        System.out.println("The following are the instructions of the game:");
        System.out.println("Use keyboard buttons left, right, up, and down arrow to have your character Pac Man collect all the coins");
        System.out.println("Watch out for red objects, those are ghosts and they eat pac man so keep away from them.");
        System.out.println("Successfully collect all the coins without the ghosts eating your Pac Man and you win!");
        System.out.println("Are you ready to play? Y / N");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine().toLowerCase().trim();
            if (input.equals("y")) {
                willPlayGame = true;
                break;
            } else if (input.equals("n")) {
                System.out.println("Ok, maybe next time. Bye!");
                System.exit(0);
            }
            System.out.println("Wrong entry! Type y or Y for yes and n or N for no.");
        }
        scanner.close();
        if (willPlayGame) {
            Main main = new Main();
            // Below code establishes window for game
            JFrame jFrame = new JFrame();
            jFrame.setTitle(Main.title);
            jFrame.add(main);
            jFrame.setResizable(false);
            jFrame.pack();
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.setLocationRelativeTo(null);
            jFrame.setVisible(true);

    		try {
    			Thread.sleep(3000);
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            main.start();
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT)
            pacMan.right = true;
        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT)
            pacMan.left = true;
        if (keyEvent.getKeyCode() == KeyEvent.VK_UP)
            pacMan.up = true;
        if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN)
            pacMan.down = true;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT)
            pacMan.right = false;
        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT)
            pacMan.left = false;
        if (keyEvent.getKeyCode() == KeyEvent.VK_UP)
            pacMan.up = false;
        if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN)
            pacMan.down = false;
    }
}
