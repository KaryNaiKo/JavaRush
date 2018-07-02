package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) throws Exception{

    }
    
    static {
        //add your code here - добавьте код тут
        try {
            reset();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Flyable result;

    public static void reset() throws Exception{
        //add your code here - добавьте код тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        if(str.equals("helicopter")) result = new Helicopter();
        else if(str.equals("plane")) {
            int passengers = Integer.parseInt(reader.readLine());
            result = new Plane(passengers);
        }
        reader.close();
    }
}
