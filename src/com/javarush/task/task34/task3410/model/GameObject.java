package com.javarush.task.task34.task3410.model;

import java.awt.*;

public abstract class GameObject {
    private int x;
    private int y;
    private int width;
    private int height;
    int FIELD_CELL_SIZE = 20;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
        this.height = FIELD_CELL_SIZE;
        this.width = FIELD_CELL_SIZE;
    }

    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public int getFIELD_CELL_SIZE() {
        return FIELD_CELL_SIZE;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public abstract void draw(Graphics graphics);
}
