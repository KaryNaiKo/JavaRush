package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        try {
            //напишите тут ваш код
            String taskString = args[0];
             //String taskString = "0";

            char[] charArray = taskString.toCharArray();
            int minRadix = 1 ;
            boolean cond = false;

            for (int i = 0; i < charArray.length; i++) {
                if(!Character.isDigit(charArray[i]) && !Character.isLetter(charArray[i])) {
                    System.out.println("incorrect");
                    cond = true;
                    break;
                }

                if(Character.isDigit(charArray[i])) {
                    if(charArray[i]-48 > minRadix ) {
                        minRadix = charArray[i]-48;
                    }
                }
                if(Character.isLetter(charArray[i])) {
                    char c = Character.toUpperCase(charArray[i]);
                    if(c - 55 > minRadix) {
                        minRadix = c - 55;
                    }
                }
            }

            if(!cond) {
                if(minRadix < 1) minRadix = 1;
                System.out.println(minRadix+1);
            }
        } catch (Exception e) {

        }
    }
}