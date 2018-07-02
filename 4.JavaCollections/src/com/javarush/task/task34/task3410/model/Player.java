package com.javarush.task.task34.task3410.model;

import java.awt.*;

/**
 * Created by Павлуша on 13.05.2018.
 */
public class Player extends CollisionObject implements Movable {
    public Player(int x, int y) {
        super(x, y);
    }

    @Override
    public void move(int x, int y) {
        setX(getX() + x);
        setY(getY() + y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.GREEN);

        graphics.fillArc(getX(), getY(), getWidth(), getHeight(),0, 360);
    }
}
