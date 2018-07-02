package com.javarush.task.task10.task1001;

/* 
Задача №1 на преобразование целых типов
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException{
        HashMap<String, Integer> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<5; i++){
            String str = reader.readLine();
            map.put(str, 1);
        }

        for(Map.Entry<String, Integer> pair :map.entrySet()){
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
