package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Павлуша on 08.03.2018.
 */
public class Cook extends Observable implements Observer{
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable o, Object arg) {
        int time = ((Order) arg).getTotalCookingTime();
        ConsoleHelper.writeMessage("Start cooking - " + arg + ", cooking time " + time + "min");
        setChanged();
        notifyObservers(arg);
    }
}
