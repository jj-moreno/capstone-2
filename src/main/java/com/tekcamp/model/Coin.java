package com.tekcamp.model;

import java.awt.*;

public class Coin extends Element{


    public Coin(int x, int y) {
        super(x, y);
    }

    public boolean disapear() {
        return false;
    }

    @Override
    public void render(Graphics g) {

    }
}
