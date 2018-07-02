package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        try {
            FileInputStream in = new FileInputStream(Statics.FILE_NAME);
            InputStreamReader st = new InputStreamReader(in);
            BufferedReader reader = new BufferedReader(st);
            String str = null;
            while ((str = reader.readLine()) != null) {
                lines.add(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
