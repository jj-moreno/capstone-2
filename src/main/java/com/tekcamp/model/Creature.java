package com.tekcamp.model;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.tekcamp.environment.MapLevel;

public class Creature extends Element implements ICreature {

	public boolean right, left, up, down;
	private int speed = 4;

	public Creature(int x, int y) {
		super(x, y);
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getSpeed() {
		return this.speed;
	}

	@Override
	public void render(Graphics g) {

	}

	@Override
	public void move() {
		if (right && canMove(x + speed, y)) {
			x += speed;
		}
		if (left && canMove(x - speed, y)) {
			x -= speed;
		}
		if (up && canMove(x, y - speed)) {
			y -= speed;
		}
		if (down && canMove(x, y + speed)) {
			y += speed;
		}
	}

	@Override
	public boolean canMove(int nextX, int nextY) {

		Rectangle bounds = new Rectangle(nextX, nextY, Element.ELEMENT_WIDTH, Element.ELEMENT_HEIGHT);
		Tile[][] mapLevelTiles = MapLevel.getTiles();

		for (Tile[] mapLevelTile : mapLevelTiles) {
			for (Tile tile : mapLevelTile) {
				if (tile != null) {
					if (bounds.intersects(tile)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	@Override
	public void eatCreature(Creature creature) {
		// TODO Auto-generated method stub

	}
}
