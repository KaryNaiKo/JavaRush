package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();

            reader.close();

            FileWriter fw = new FileWriter(fileName2);
            FileReader fr = new FileReader(fileName1);

            int count=1;
            int data;
            while ((data = fr.read()) != -1 ){
                if(count%2 == 0){
                    fw.write(data);
                }
                count++;
            }

            fr.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
