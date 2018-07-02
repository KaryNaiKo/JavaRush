package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.*;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws Exception{
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        FileInputStream fis = new FileInputStream(str);
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(fis));
        StringBuilder sb = new StringBuilder();

        while (fileReader.ready()) {
            sb.append(fileReader.readLine());

        }

        StringBuilder result = getLine(sb.toString().split(" "));
        //StringBuilder result = getLine("Киев Нью-Йорк Амстердам Вена Мельбурн Дан".split(" "));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        if(words.length == 0) return sb.append("");


        List<String> list =  Arrays.asList(words);
        ArrayList<String> arrayList = new ArrayList<>(list);
        Collections.sort(arrayList);

        sb.append(arrayList.get(0)).append(' ');
        arrayList.remove(0);


        boolean cond = true;
        while(cond) {
            char ch = sb.charAt(sb.length()-2);
            String str = ch + "";

            for (int j = 0; j < arrayList.size(); j++) {
                char tempChar = arrayList.get(j).charAt(0);
                String tempStr = tempChar + "";
                if(str.equalsIgnoreCase(tempStr)) {
                    sb.append(arrayList.get(j)).append(' ');
                    arrayList.remove(j);
                    break;
                }
                if(j == arrayList.size()-1) {
                    cond = false;
                    break;
                }
            }

            if(arrayList.size() == 0) cond = false;
        }

        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(arrayList.get(i)).append(' ');
        }

        return sb.deleteCharAt(sb.length()-1);
    }
}
