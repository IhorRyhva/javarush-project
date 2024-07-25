package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Player extends CollisionObject implements Movable{
    private Graphics graphics = null;
    public Player(int x, int y) {
        super(x, y);
    }

    @Override
    public void move(int x, int y) {
        super.setX(super.getX() + x);
        super.setY(super.getY() + y);
    }

    @Override
    public void draw(Graphics graphics) {
        this.graphics = graphics;
        graphics.setColor(Color.YELLOW);
        graphics.fillOval(super.getX(), super.getY(), 20, 20);
        graphics.drawOval(super.getX(), super.getY(), 20, 20);
    }
}
