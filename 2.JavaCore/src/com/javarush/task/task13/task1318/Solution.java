package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameToRead = reader.readLine();

        FileInputStream in = new FileInputStream(fileNameToRead);


        while(in.available() > 0){
            char ch = (char)in.read();
            System.out.print(ch);
        }
        System.out.println();

        in.close();
        reader.close();
    }
}