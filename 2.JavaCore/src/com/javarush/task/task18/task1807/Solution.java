package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file_in = new FileInputStream(reader.readLine());

        int count = 0;

        while (file_in.available() > 0) {
            if(file_in.read() == 44) count++;
        }

        System.out.println(count);
        file_in.close();
        reader.close();
    }
}
