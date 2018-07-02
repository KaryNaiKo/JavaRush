package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        FileOutputStream file_1 = new FileOutputStream(fileName1);
        FileInputStream  file_2 = new FileInputStream(fileName2);

        while (file_2.available() > 0){
            file_1.write(file_2.read());
        }
        file_1 = new FileOutputStream(fileName1, true);
        FileInputStream  file_3 = new FileInputStream(fileName3);

        while (file_3.available() > 0){
            file_1.write(file_3.read());
        }
        reader.close();
        file_1.close();
        file_2.close();
        file_3.close();
    }
}
