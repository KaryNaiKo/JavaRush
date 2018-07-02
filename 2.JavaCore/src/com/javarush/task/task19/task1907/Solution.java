package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        int count = 0;


        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName1 = reader.readLine();
            reader.close();

            FileReader fr = new FileReader(fileName1);

            int i;
            String str = "";
            while(fr.ready()){
                i=fr.read();
                Character ch = (char) i;
                if(Character.isLetter(ch)) {
                    str = str + ch;
                }
                else {
                    if(str.equals("world")) count++;
                    str = "";
                }
            }
            System.out.println(count);

            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
