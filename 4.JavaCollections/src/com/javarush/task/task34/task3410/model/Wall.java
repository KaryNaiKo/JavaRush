package com.javarush.task.task34.task3410.model;

import java.awt.*;

/**
 * Created by Павлуша on 13.05.2018.
 */
public class Wall extends CollisionObject {
    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(new Color(101, 67, 33));
        graphics.fillRect(getX(), getY(), getWidth(), getHeight());
    }
}
