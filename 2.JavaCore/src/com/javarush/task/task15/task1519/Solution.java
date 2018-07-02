package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        String output = null;
        double d;
        int i;
        while(!(str = reader.readLine()).equals("exit")){

            if(str.contains(".")){
                try {
                    print(Double.parseDouble(str));
                } catch (NumberFormatException e) {
                    print(str);
                }
            } else {
                try {
                    i = Integer.parseInt(str);
                    if(i<128 && i>0) print((short)i);
                    else print(i);
                } catch (NumberFormatException e) {
                    print(str);
                }

            }
       }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
