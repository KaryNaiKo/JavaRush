package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws Exception{
        int countOfspace = 0;
        int countOfAllChar = 0;
        String str = args[0];

        FileInputStream fin = new FileInputStream(str);

        while (fin.available() > 0){
            int bt = fin.read();

            if(bt == ' ') {
                countOfspace++;
                countOfAllChar++;
            }
            else countOfAllChar++;
        }
        fin.close();

        System.out.format(Locale.ENGLISH,"%.2f" ,(double)countOfspace/countOfAllChar * 100);

    }
}
