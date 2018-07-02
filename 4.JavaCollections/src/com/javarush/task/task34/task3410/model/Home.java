package com.javarush.task.task34.task3410.model;

import java.awt.*;

/**
 * Created by Павлуша on 13.05.2018.
 */
public class Home extends GameObject {
    public Home(int x, int y) {
        super(x, y);
        setWidth(2);
        setHeight(2);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.drawOval(getX(), getY(), getWidth(), getHeight());
    }
}
