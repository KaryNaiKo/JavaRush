package com.javarush.task.task18.task1808;

/* 
Разделение файла
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
        String file3 = reader.readLine();

        FileInputStream file_in = new FileInputStream(file1);
        FileOutputStream file_out_1 = new FileOutputStream(file2);
        FileOutputStream file_out_2 = new FileOutputStream(file3);

        int countOfFileByte = file_in.available();

        while (file_in.available() > 0) {
            if(file_in.available() > countOfFileByte/2) {
                file_out_1.write(file_in.read());
            }
            else {
                file_out_2.write(file_in.read());
            }
        }

        reader.close();
        file_in.close();
        file_out_1.close();
        file_out_2.close();
    }
}
