package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file_in = null;
        String fileName;
        boolean cond = true;

        while (cond) {
            fileName = reader.readLine();
            if(fileName.equals("")) throw new DownloadException();
            file_in = new FileInputStream(fileName);

            if(file_in.available() < 1000) {
                file_in.close();
                reader.close();
                throw new DownloadException();
            }

        }



    }

    public static class DownloadException extends Exception {

    }
}
