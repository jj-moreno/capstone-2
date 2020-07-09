package com.tekcamp.model;

import java.awt.*;

public class PacMan extends Element {

    public PacMan(int x, int y) {
        super(x, y);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(x, y, width, height);
    }


    public boolean eatCoin(Coin coin) {
        return false;
    }
}
