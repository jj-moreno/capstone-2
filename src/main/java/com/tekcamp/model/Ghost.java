package com.tekcamp.model;

import java.awt.*;

public class Ghost extends Element {

    private String color;

    public Ghost(int x, int y, String color) {
        super(x, y);
        this.color = color.toLowerCase();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.getColor(this.color));
        g.fillRect(x, y, width, height);
    }

    public void chaseCharacter(Character character) {

    }

    public void relocate(int locationX, int locationY) {

    }
}
