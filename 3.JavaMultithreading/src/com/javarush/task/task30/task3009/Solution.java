package com.javarush.task.task30.task3009;

import java.math.BigInteger;
import java.util.*;

/* 
Палиндром?
*/

public class Solution {


    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number) {
        HashSet<Integer> set = new HashSet<>();

        try {
            int max = maxIntNew(number) +1;
            String str = "";
            for (int i = 2; i <= 36; i++) {
                str = Integer.toString(Integer.valueOf(number), i);
                if(isPalindrom(str)) {
                    set.add(i);
                }
            }
        } catch (NumberFormatException e) {

        }

        return set;
    }

    private static boolean isPalindrom(String str) {
        char[] charArray = str.toCharArray();

        for (int i = 0; i < charArray.length/2; i++) {
            if(charArray[i] != charArray[charArray.length-1-i]) return false;
        }

        return true;
    }


    private static int maxIntNew(String str) {
        char[] charArray = str.toCharArray();
        int max = 0;

        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i]-48 > max) max = charArray[i]-48;
        }

        return max;
    }


}