package com.tekcamp.model;

import java.awt.*;

public abstract class Element extends Rectangle {

    public boolean right, left, up, down;
    private int speed = 4;

    public Element(int x, int y) {
        setBounds(x, y, 32, 32);
    }

    public void tick() {
        if (right)
            x += speed;
        if (left)
            x -= speed;
        if (up)
            y -= speed;
        if (down)
            y += speed;
    }

    public abstract void render(Graphics g);
}
