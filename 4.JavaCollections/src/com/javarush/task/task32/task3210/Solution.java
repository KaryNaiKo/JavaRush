package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws Exception{
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];
        byte[] readBytes = new byte[text.length()];


        RandomAccessFile reader = new RandomAccessFile(fileName, "rw");

        if(reader.length() > number) {
            reader.seek(number);
            reader.read(readBytes, 0, readBytes.length);

            String newtext = new String(readBytes);
            if(newtext.equals(text)) {
                reader.seek(reader.length());
                reader.write("true".getBytes());
            } else {
                reader.seek(reader.length());
                reader.write("false".getBytes());
            }
        } else {
            reader.seek(reader.length());
            reader.write("false".getBytes());
        }
    }
}
