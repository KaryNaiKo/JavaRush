package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import java.nio.file.Paths;
import java.util.Set;

/**
 * Created by Павлуша on 13.05.2018.
 */
public class Model {
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("4.JavaCollections/src/com/javarush/task/task34/task3410/res/levels.txt"));
    private EventListener eventListener;
    public static final int FIELD_CELL_SIZE = 20;

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level) {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        restartLevel(++currentLevel);
    }

    public void move(Direction direction) {
        Player player = gameObjects.getPlayer();
        if(checkWallCollision(player, direction)) return;
        if(checkBoxCollisionAndMoveIfAvaliable(direction)) return;
        moveObjectToDirection(player, direction);
        checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        Set<Wall> walls = gameObjects.getWalls();
        boolean isNoColision = false;
        for (Wall wall : walls) {
            isNoColision = gameObject.isCollision(wall, direction);
            if(isNoColision) return isNoColision;
        }
        return isNoColision;
    }

    public boolean checkBoxCollisionAndMoveIfAvaliable(Direction direction) {
        Player player = gameObjects.getPlayer();
        GameObject stoped = null;
        for (GameObject gameObject : gameObjects.getAll()) {
            if (!(gameObject instanceof Player) && !(gameObject instanceof Home) && player.isCollision(gameObject, direction)) {
                stoped = gameObject;
            }
        }

        if ((stoped == null)) {
            return false;
        }

        if (stoped instanceof Box) {
            Box stopedBox = (Box) stoped;
            if (checkWallCollision(stopedBox, direction)) {
                return true;
            }
            for (Box box : gameObjects.getBoxes()) {
                if (stopedBox.isCollision(box, direction)) {
                    return true;
                }
            }

            switch (direction) {
                case LEFT:
                    stopedBox.move(-FIELD_CELL_SIZE, 0);
                    break;
                case RIGHT:
                    stopedBox.move(FIELD_CELL_SIZE, 0);
                    break;
                case UP:
                    stopedBox.move(0, -FIELD_CELL_SIZE);
                    break;
                case DOWN:
                    stopedBox.move(0, FIELD_CELL_SIZE);
            }
        }
        return false;

    }

//    public boolean checkBoxCollisionAndMoveIfAvaliable(Direction direction) {
//        Player player = gameObjects.getPlayer();
//        if(checkWallCollision(player, direction)) return true;
//
//        Set<Box> boxes = gameObjects.getBoxes();
//        boolean isNoColisionWhithBox = false;
//        for (Box box : boxes) {
//            if(player.isCollision(box, direction)) {
//                if(checkWallCollision(box, direction)) {
//                    return true;
//                } else {
//                    for (Box secondBox : boxes) {
//                        if(box.isCollision(secondBox, direction)) return true;
//                    }
//                    moveObjectToDirection(box, direction);
//                }
//            }
//        }
//        return isNoColisionWhithBox;
//    }

    public void checkCompletion() {
        Set<Box> boxes = gameObjects.getBoxes();
        Set<Home> homes = getGameObjects().getHomes();

        boolean isBoxOnHome;
        for (Box box : boxes) {
            int x = box.getX();
            int y = box.getY();
            isBoxOnHome = false;
            for (Home home : homes) {
                if(x == home.getX() && y == home.getY()) isBoxOnHome = true;
            }
            if(!isBoxOnHome) return;
        }

        eventListener.levelCompleted(currentLevel);
    }

    private void moveObjectToDirection(Movable movable, Direction direction) {
        switch (direction) {
            case UP:
                movable.move(0, -Model.FIELD_CELL_SIZE);
                break;
            case DOWN:
                movable.move(0, Model.FIELD_CELL_SIZE);
                break;
            case LEFT:
                movable.move(-Model.FIELD_CELL_SIZE, 0);
                break;
            case RIGHT:
                movable.move(Model.FIELD_CELL_SIZE, 0);
                break;
        }
    }

}
