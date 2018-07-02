package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();

        FileInputStream fin = new FileInputStream(name);
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(fin));
        String index = args[0];
        String fileLine = "";
        while ((fileLine = fileReader.readLine()) != null) {
            String[] str = fileLine.split(" ");

            if(str[0].equals(index)) System.out.println(str[0] + " " + str[1] + " " + str[2] + " " + str[3]);
        }

        reader.close();
        fin.close();
        fileReader.close();
    }
}
