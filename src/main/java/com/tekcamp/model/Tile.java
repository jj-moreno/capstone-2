package com.tekcamp.model;

import java.awt.*;

public class Tile extends Element {


	public Tile(int x, int y) {
    	super(x, y);
    }


    public void render(Graphics g) {
    	g.setColor(Color.blue);
        g.fillRect(super.x, super.y, super.width, super.height);
    }
}
