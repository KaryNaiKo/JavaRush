package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public void fill(double numberOfLiters) throws Exception{
        if (numberOfLiters < 0)
            throw new Exception();
        fuel += numberOfLiters;

    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
/*
        double consumption;
        if (date.before(SummerStart) || date.after(SummerEnd)) {
            consumption = length * winterFuelConsumption + winterWarmingUp;
        } else {
            consumption = length * summerFuelConsumption;
        }
        return consumption;
*/

        if(isSummer(date, SummerStart, SummerEnd)) {
            return getSummerConsumption(length);
        } else {
            return getWinterConsumption(length);
        }
    }

    public int getNumberOfPassengersCanBeTransferred() {
/*
        if (!isDriverAvailable())
            return 0;
        if (fuel <= 0)
            return 0;
*/
        if(!canPassengersBeTransferred()) return 0;
        else return numberOfPassengers;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
/*        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
            fastenDriverBelt();
        } else {
            fastenDriverBelt();
        }*/
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
        fastenDriverBelt();
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();
/*        if (type == TRUCK)
            return 80;
        if (type == SEDAN)
            return 120;
        return 90;*/


//        if (type == TRUCK)
//            return MAX_TRUCK_SPEED;
//        if (type == SEDAN)
//            return MAX_SEDAN_SPEED;
//        return MAX_CABRIOLET_SPEED;


    public static Car create(int type, int numberOfPassengers) {
        switch (type) {
            case TRUCK:
                return new Truck(numberOfPassengers);
            case SEDAN:
                return new Sedan(numberOfPassengers);
            case CABRIOLET:
                return new Cabriolet(numberOfPassengers);
        }
        return null;
    }

    public boolean isSummer(Date date , Date summerStart, Date summerEnd) {
        return date.before(summerEnd) && date.after(summerStart);
    }
    public double getWinterConsumption(int length) {
        return winterFuelConsumption*length + winterWarmingUp;
    }
    public  double getSummerConsumption(int length) {
        return summerFuelConsumption*length;
    }

    private boolean canPassengersBeTransferred() {
        if (!isDriverAvailable())
            return false;
        if (fuel <= 0)
            return false;
        return true;
    }
}