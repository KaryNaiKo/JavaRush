package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fIn = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        byte max = 0;
        int temp = 0;
        while (fIn.available() > 0){
            temp = fIn.read();
            if(max < temp) max = (byte) temp;
        }
        System.out.println(max);
        fIn.close();
    }
}
