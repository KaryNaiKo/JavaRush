package com.javarush.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {

        if (reader != null) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder str = new StringBuilder();

            str.append(bufferedReader.readLine());

            char[] chars = str.toString().toCharArray();
            for (int i = 0; i < chars.length; i++) {
                chars[i] += key;
            }

            return new String(chars);
        }
        return "";
    }
}
