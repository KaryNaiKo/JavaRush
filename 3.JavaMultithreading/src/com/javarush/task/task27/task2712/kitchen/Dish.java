package com.javarush.task.task27.task2712.kitchen;

/**
 * Created by Павлуша on 15.02.2018.
 */
public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    //////////////////fields///////////////////
    private int duration;

    ///////////////////Methods//////////////////
    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }


    public static String allDishesToString() {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < Dish.values().length; i++) {
            str.append(Dish.values()[i]);
            if(i < Dish.values().length-1) str.append(", ");
        }

        return str.toString();
    }


}
