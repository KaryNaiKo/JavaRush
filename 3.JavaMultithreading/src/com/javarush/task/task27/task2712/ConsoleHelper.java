package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Павлуша on 15.02.2018.
 */
public class ConsoleHelper {


    //для вывода message в консоль
    static public void writeMessage(String message) {
        System.out.println(message);
    }

    static public String readString() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException{
        List<Dish> dishes = new ArrayList<>();
        writeMessage(Dish.allDishesToString());
        writeMessage("Enter the dishes please");
        String dishName;
        while (true)
        {
            dishName = readString();
            if (dishName.equalsIgnoreCase("exit"))
            {
                break;
            }
            try
            {
                dishes.add(Dish.valueOf(dishName));
            }
            catch (IllegalArgumentException e)
            {
                writeMessage("There is no such dish");
            }
        }
        return dishes;
    }
}
