package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Home extends GameObject{

    public Home(int x, int y) {
        super(x, y);
        super.setHeight(2);
        super.setWidth(2);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.drawOval(super.getX(), super.getY(), super.getHeight(), super.getWidth());
    }
}
