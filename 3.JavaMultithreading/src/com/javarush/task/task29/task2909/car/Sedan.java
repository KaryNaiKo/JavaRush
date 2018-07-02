package com.javarush.task.task29.task2909.car;

/**
 * Created by Павлуша on 12.12.2017.
 */
public class Sedan extends Car {
    final int MAX_SEDAN_SPEED = 120;

    public Sedan(int numberOfPassengers) {
        super(Car.SEDAN, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_SEDAN_SPEED;
    }
}
