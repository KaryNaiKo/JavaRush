package com.javarush.task.task34.task3410.model;

/**
 * Created by Павлуша on 13.05.2018.
 */
public abstract class CollisionObject extends GameObject{
    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction) {
        int distanationX = getX();
        int distanationY = getY();

        switch (direction) {
            case RIGHT:
                distanationX += Model.FIELD_CELL_SIZE;
                break;
            case LEFT:
                distanationX -= Model.FIELD_CELL_SIZE;
                break;
            case DOWN:
                distanationY += Model.FIELD_CELL_SIZE;
                break;
            case UP:
                distanationY -= Model.FIELD_CELL_SIZE;
                break;
        }

        return distanationX == gameObject.getX() && distanationY == gameObject.getY();
    }
}
