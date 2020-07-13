package com.tekcamp.model;

import java.awt.*;

public class Coin extends Element {
    private final static int COIN_WIDTH = 8;
    private final static int COIN_HEIGHT = 8;
    private final static int COIN_CENTER_OFFSET = 12;

    public Coin(int x, int y) {
        super(x + COIN_CENTER_OFFSET, y + COIN_CENTER_OFFSET, COIN_WIDTH, COIN_HEIGHT);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(super.x, super.y, COIN_WIDTH, COIN_HEIGHT);
    }
}
