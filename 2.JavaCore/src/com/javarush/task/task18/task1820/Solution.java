package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileInputStream input = new FileInputStream(file1);
        FileWriter writer = new FileWriter(file2);

        //Заполнение объекта StringBuilder
        StringBuilder builder = new StringBuilder();
        while (input.available() > 0) builder.append((char) input.read());
        String[] totalLine = builder.toString().split(" ");

        //Записываем во второй файл округленные числа через пробел
        String forOut;
        for (int i = 0; i < totalLine.length; i++) {
            forOut = Long.toString(Math.round(Double.parseDouble(totalLine[i])));
            writer.write(forOut+" ");
        }

        //Закрытие потоков
        input.close();
        writer.close();
    }
}
