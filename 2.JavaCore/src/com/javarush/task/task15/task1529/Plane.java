package com.javarush.task.task15.task1529;

/**
 * Created by Павлуша on 27.07.2017.
 */
public class Plane implements Flyable {
    private int NumOfPassengers;

    @Override
    public void fly() {

    }

    public Plane(int passengers){
        NumOfPassengers = passengers;
    }
}
