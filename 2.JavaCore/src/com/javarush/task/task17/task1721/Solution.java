package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args)  {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fin1 = null;
        FileInputStream fin2 = null;
        try {
            String fistFileName = reader.readLine();
            String secondFileName = reader.readLine();
            fin1 = new FileInputStream(fistFileName);
            fin2 = new FileInputStream(secondFileName);

        } catch (IOException e) {
            e.printStackTrace();
        }

        file_read_allLines(fin1);
        file_read_forRemoveLines(fin2);
        try {
            fin1.close();
            fin2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }

    }

    public void joinData () throws CorruptedDataException {
        boolean compared = false;

        for(int i=0; i<forRemoveLines.size(); i++) {
            if(!allLines.contains(forRemoveLines.get(i))) {
                compared = true;
                break;
            }
        }
        if(!compared){
            // совпало все
            for(int i=0; i<forRemoveLines.size(); i++) {
                allLines.remove(forRemoveLines.get(i));
            }
        }
        else {
            // не было совпадения
            allLines.clear();
            throw new CorruptedDataException();
        }
    }

    public static void file_read_forRemoveLines(FileInputStream in){
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String str = "";
        try {
            while ((str = reader.readLine()) != null) {
                forRemoveLines.add(str);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void file_read_allLines(FileInputStream in){
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String str = "";
        try {
            while ((str = reader.readLine()) != null) {
                allLines.add(str);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
