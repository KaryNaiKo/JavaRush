package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        FileReader fr = new FileReader(fileName1);
        FileWriter fw = new FileWriter(fileName2);

        BufferedReader reader1 = new BufferedReader(fr);
        BufferedWriter writer = new BufferedWriter(fw);

        while (reader1.ready()) {
            int i = reader1.read();
            Character c = (char) i;
            if (Character.isAlphabetic(c) || Character.isDigit(c) || Character.isSpaceChar(c)) {
                writer.write(i);
            }

        }

        reader1.close();
        writer.close();
    }
}
