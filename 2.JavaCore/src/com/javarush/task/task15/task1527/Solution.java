package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws Exception{
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String[] str1;
        char[] ch = str.toCharArray();
        str1 = str.split("\\?");

        str1 = str1[1].split("&");

        String[] str2;
        boolean cond_d = false;
        boolean cond_s = false;
        double d = 0;
        String temp = null;
        for(int i=0; i<str1.length; i++){
            str2 = str1[i].split("=");
            if(str2[0].equals("obj")){
                try {
                    d = Double.parseDouble(str2[1]);
                    cond_d = true;
                } catch (NumberFormatException e) {
                    temp = str2[1];
                    cond_s = true;
                }
            }
            System.out.print(str2[0] + " ");
        }

        if(cond_d) {
            System.out.println();
            alert(d);
        }
        if(cond_s) {
            System.out.println();
            alert(temp);
        }
//        System.out.println(str1.length);
//        for(int i=0; i<str1.length; i++){
//            System.out.println(str1[i]);
//        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
