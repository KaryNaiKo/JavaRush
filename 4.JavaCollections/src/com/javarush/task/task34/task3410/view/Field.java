package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.controller.EventListener;
import com.javarush.task.task34.task3410.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;

/**
 * Created by Павлуша on 13.05.2018.
 */
public class Field extends JPanel {
    private EventListener eventListener;
    private View view;

    public Field(View view) {
        this.view = view;
        addKeyListener(new KeyHandler());
        setFocusable(true);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0, view.getWidth(), view.getHeight());
        GameObjects gameObjects = view.getGameObjects();
        Set<GameObject> set = gameObjects.getAll();
        for (GameObject object: set) {
            object.draw(g);
        }
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public class KeyHandler extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT :
                    eventListener.move(Direction.LEFT);
                    break;
                case KeyEvent.VK_RIGHT :
                    eventListener.move(Direction.RIGHT);
                    break;
                case KeyEvent.VK_UP :
                    eventListener.move(Direction.UP);
                    break;
                case KeyEvent.VK_DOWN :
                    eventListener.move(Direction.DOWN);
                    break;
                case KeyEvent.VK_R:
                    eventListener.restart();
                    break;
                case KeyEvent.VK_N :
                    eventListener.next();
                    break;
            }
        }
    }
}
