package com.tekcamp.model;

public interface IElement {
    void move(int locationX, int locationY);
    boolean eatCharacter(Character character);
}
