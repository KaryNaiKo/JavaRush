package com.javarush.task.task14.task1417;

/**
 * Created by Павлуша on 21.07.2017.
 */
public class USD extends Money {
    private double amount;
    public USD(double amount) {
        super(amount);
    }

    @Override
    public String getCurrencyName() {
        return "USD";
    }
}
