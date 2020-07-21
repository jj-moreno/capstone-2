package com.tekcamp.model;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Element extends Rectangle {

    protected static final int ELEMENT_WIDTH = 32;
    protected static final int ELEMENT_HEIGHT = 32;
    
    public Element(int x, int y) {
        setBounds(x, y, ELEMENT_WIDTH, ELEMENT_HEIGHT);
    }
    
    protected Element(int x, int y, int elementWidth, int elementHeight) {
    	setBounds(x, y, elementWidth, elementHeight);
    }

    public abstract void render(Graphics g);
}
