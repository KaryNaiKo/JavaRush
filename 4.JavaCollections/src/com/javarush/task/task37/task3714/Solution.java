package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* 
Древний Рим
*/
public class Solution {
    private static HashMap<Character, Integer> map = new HashMap<>();

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        int lastDigit = 0;
        int currentDigit = 0;

        for (int i = 0; i < chars.length; i++) {
            currentDigit = map.get(chars[chars.length-1-i]);
            if(currentDigit >= lastDigit) sum = sum + currentDigit;
            else sum = sum - currentDigit;

            lastDigit = currentDigit;
        }

        return sum;
    }
}
