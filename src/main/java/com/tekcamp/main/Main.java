package com.tekcamp.main;

import com.tekcamp.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.*;

public class Main extends Canvas implements Runnable, KeyListener {

    private boolean isRunning = false;
    public static final int WINWIDTH = 640;
    public static final int WINHEIGHT = 705;
    public static final String title = "Pac-Man";

    private Thread thread;

    public static Element pacMan;

    public Main() {
        Dimension dimension = new Dimension(Main.WINWIDTH, Main.WINHEIGHT);
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);

        addKeyListener(this);
        pacMan = new PacMan(301, 519);
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
        pacMan.tick();
    }

    private void render() {
        BufferStrategy bufferStrategy = getBufferStrategy();

        // initializes bufferStrategy for first render call
        if (bufferStrategy == null) {
            createBufferStrategy(3);
            return;
        }
        // after having a bufferStrategy we can create graphics object using bufferStrategy
        Graphics g = bufferStrategy.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0,0, Main.WINWIDTH, Main.WINHEIGHT);
        pacMan.render(g);
        g.dispose();
        bufferStrategy.show();
    }

    @Override
    public void run() {
        requestFocus(); // allows our keypress to be tied to the game window
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
                System.out.println(fps);
                fps = 0;
                timer += 1000;
            }
        }

        stop();

    }

    public static void main(String[] args) {

        Main main = new Main();
        //Below code establishes window for game
        JFrame jFrame = new JFrame();
        jFrame.setTitle(Main.title);
        jFrame.add(main);
        jFrame.setResizable(false);
        jFrame.pack();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

        main.start();

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
