package com.javarush.task.task15.task1522;

/**
 * Created by Павлуша on 23.07.2017.
 */
public class Moon implements Planet{
    private static Moon instance;

    public static Moon getInstance() {
        if(instance == null) return instance = new Moon();
        else return instance;
    }

    private Moon() {
    }
}
