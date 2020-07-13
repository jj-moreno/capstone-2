package com.tekcamp.model;

public interface ICreature {
	void move();
	boolean canMove(int nextX, int nextY);
    void eatCreature(Creature creature);
}
