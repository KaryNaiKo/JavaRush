package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        int count = 0;
        String str = args[0];

        FileInputStream fin = new FileInputStream(str);

        while (fin.available() > 0){
            int bt = fin.read();

            if(( bt >= 'a' && bt <= 'z') || (bt >= 'A' && bt <= 'Z')) count++;
        }
        fin.close();
        System.out.println(count);
    }
}
