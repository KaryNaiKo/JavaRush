package com.javarush.task.task29.task2909.car;

/**
 * Created by Павлуша on 12.12.2017.
 */
public class Cabriolet extends Car {
    final int MAX_CABRIOLET_SPEED = 90;

    public Cabriolet(int numberOfPassengers) {
        super(Car.CABRIOLET, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_CABRIOLET_SPEED;
    }
}
