package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException{
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileToSelect = reader.readLine();

        FileInputStream fin = new FileInputStream(fileToSelect);
        InputStreamReader isr = new InputStreamReader(fin);
        BufferedReader fileReader = new BufferedReader(isr);

        ///
/*        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
        System.out.println(in.readLine());*/
        //System.out.println(fileReader.readLine());
        ///
        String str;
        ArrayList<Integer> list = new ArrayList<>();
        while( (str = fileReader.readLine()) != null){

            int i = Integer.parseInt(str);
            if(i % 2 == 0) list.add(i);

        }

        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }




        fileReader.close();
        isr.close();
        fin.close();
        reader.close();
    }
}
