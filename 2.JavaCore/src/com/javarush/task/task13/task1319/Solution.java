package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameToRead = reader.readLine();

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileNameToRead));

        ArrayList<String> list = new ArrayList<>();

        while(true){
            String str = reader.readLine();
            if(str.equals("exit")){
                list.add(str);
                break;
            }
            else {
                list.add(str);
            }
        }



        for(String str : list){
            writer.write(str);
            writer.newLine();
        }

        reader.close();
        writer.close();

    }
}
