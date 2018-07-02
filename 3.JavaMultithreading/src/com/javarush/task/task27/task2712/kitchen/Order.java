package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Павлуша on 15.02.2018.
 */
public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException{
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public int getTotalCookingTime(){
        int totalCookingTime = 0;
        for (int i = 0; i < dishes.size(); i++) {
            totalCookingTime += dishes.get(i).getDuration();
        }
        return totalCookingTime;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    @Override
    public String toString() {
        return "Your order: " +
                dishes +
                " of " +
                tablet;
    }
}
