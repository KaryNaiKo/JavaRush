package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileInputStream file_in = new FileInputStream(file1);
        FileOutputStream file_out_1 = new FileOutputStream(file2);

        byte[] buffer = new byte[file_in.available()];
        file_in.read(buffer);

        for(int i=buffer.length-1; i>=0; i--){
            file_out_1.write(buffer[i]);
        }


        reader.close();
        file_in.close();
        file_out_1.close();
    }
}
