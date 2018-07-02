package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();


        FileInputStream fileInputStream_file1 = new FileInputStream(fileName1);
        FileInputStream fileInputStream_file2 = new FileInputStream(fileName2);

        ArrayList<Integer> list = new ArrayList<>();

        //Считать из первого файла в лист
        while (fileInputStream_file1.available() > 0) {
            list.add(fileInputStream_file1.read());
        }

        FileOutputStream fileOutputStream = new FileOutputStream(fileName1);

        //Записать в первый файл данные из второго
        while (fileInputStream_file2.available() > 0) {
            fileOutputStream.write(fileInputStream_file2.read());
        }

        fileOutputStream = new FileOutputStream(fileName1, true);

        //Записать из лист в конец первого файла
        for (int i : list) {
            fileOutputStream.write(i);
        }

        fileInputStream_file1.close();
        fileInputStream_file2.close();
        fileOutputStream.close();
    }
}
