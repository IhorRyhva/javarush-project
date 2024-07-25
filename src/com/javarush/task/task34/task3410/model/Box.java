package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Box extends CollisionObject implements Movable{
    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.ORANGE);
        graphics.drawLine(super.getX(), super.getY(), super.getX() + 20, super.getY() + 20);
        graphics.drawLine(super.getX(), super.getY() + 20, super.getX() + 20, super.getY());
        graphics.drawRect(super.getX(), super.getY(), 20, 20);
    }

    @Override
    public void move(int x, int y) {
        super.setX(super.getX() + x);
        super.setY(super.getY() + y);
    }
}
