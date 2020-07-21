package com.tekcamp.model;

import java.awt.Color;
import java.awt.Graphics;

public class PacMan extends Creature {

    public PacMan(int x, int y) {
        super(x, y);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(x, y, super.width, super.height);
    }

    public boolean eatCoin(Coin coin) {
        return this.intersects(coin);
    }
}
