package com.tekcamp.model;

import java.awt.*;
import java.util.Random;

public class Ghost extends Creature {

    private final static int right = 0;
    private final static int left = 1;
    private final static int up = 2;
    private final static int down = 3;
    private static final int random = 0;
    private static final int smart = 1;
    private static final int findPath = 2;
    private int dir;
    private int lastDir;
    private int state;
    private final static Random RANDOM_GEN = new Random();
    private int time;
    private final static int TARGET_TIME = 60 * 4;
    public boolean move;

    public Ghost(int x, int y) {
        super(x, y);
        this.dir = RANDOM_GEN.nextInt(4);
        this.lastDir = dir;
        this.state = random;
        this.time = 0;
        this.move = false;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRoundRect(x, y, super.width, super.height, 16, 16);
    }

    public void eatCreature(Creature creature) {
        super.setSpeed(2);
        int speed = super.getSpeed();
        if (state == random) {
            checkCaughtCreature(creature);
            switch (dir) {
                case right:
                    if (super.canMove(x + speed, y)) { // check if can move right
                        x += speed;
                    } else {
                        dir = RANDOM_GEN.nextInt(4);
                    }
                    break;
                case left:
                    if (super.canMove(x - speed, y)) { // check if can move left
                        x -= speed;
                    } else {
                        dir = RANDOM_GEN.nextInt(4);
                    }
                    break;
                case up:
                    if (canMove(x, y - speed)) { // check if can move up
                        y -= speed;
                    } else {
                        dir = RANDOM_GEN.nextInt(4);
                    }
                    break;
                case down:
                    if (canMove(x, y + speed)) { // check if can move down
                        y += speed;
                    } else {
                        dir = RANDOM_GEN.nextInt(4);
                    }
                    break;
                default:
                	dir = RANDOM_GEN.nextInt(4);
                    break;
            }

            time++;
            if (time >= TARGET_TIME) {
                time = 0;
                state = smart;
            }
        } else if (state == smart) {

            if (x < creature.x) { // is creature to eat to the right, if so ...
                if (canMove(x + speed, y)) { // try to move right
                    x += speed;
                    move = true; // successful movement
                    lastDir = right;
                }
            }

            if (x > creature.x) { // is creature to eat to the left, if so ...
                if (canMove(x - speed, y)) { // try to move left
                    x -= speed;
                    move = true; // successful movement
                    lastDir = left;
                }
            }

            if (y < creature.y) { // is creature to eat below, if so ...
                if (canMove(x, y + speed)) { // try to move down
                    y += speed;
                    move = true; // successful movement
                    lastDir = down;
                }
            }

            if (y > creature.y) { // is creature to eat above, if so ...
                if (canMove(x, y - speed)) { // try to move up
                    y -= speed;
                    move = true; // successful movement
                    lastDir = up;
                }
            }

            checkCaughtCreature(creature);

            if (!move) {
                state = findPath;
            }

            time++;
            if (time >= TARGET_TIME * 4) {
                time = 0;
                state = random;
            }
            move = false;
        } else if (state == findPath) {
            if (lastDir == right) { // if we went right

                lookForCreatureOnY(creature, speed);

                if (canMove(x + speed, y)) { // try to continue path
                    x += speed;
                    state = smart;
                }

            } else if (lastDir == left) { // if we went left

                lookForCreatureOnY(creature, speed);

                if (canMove(x - speed, y)) { // try to continue path
                    x -= speed;
                    state = smart;
                }

            } else if (lastDir == up) { // if we went up

                lookForCreatureOnX(creature, speed);

                if (canMove(x, y - speed)) { // try to continue path
                    y -= speed;
                    state = smart;
                }

            } else if (lastDir == down) { // if we went down

                lookForCreatureOnX(creature, speed);

                if (canMove(x, y + speed)) { // try to continue path
                    y += speed;
                    state = smart;
                }
            }
        }
        time++;
        if (time >= TARGET_TIME * 2) {
            time = 0;
            state = random;
        }
    }

    private void lookForCreatureOnX(Creature creature, int speed) {
        if (x < creature.x) { // if creature to the right
            if (canMove(x + speed, y)) { // try to move right
                x += speed;
                state = smart;
            }
        } else { // creature to the left
            if (canMove(x - speed, y)) { // try to move left
                x -= speed;
                state = smart;
            }
        }
    }

    private void lookForCreatureOnY(Creature creature, int speed) {
        if (y < creature.y) { // if creature below
            if (canMove(x, y + speed)) { // try to go down
                y += speed;
                state = smart;
            }
        } else { // creature is above
            if (canMove(x, y - speed)) { // try to move up
                y -= speed;
                state = smart;
            }
        }
    }

    private void checkCaughtCreature(Creature creature) {

        if (x == creature.x && y == creature.y) {
            System.out.println("GAME OVER!");
            System.exit(0);
        }
    }

}
