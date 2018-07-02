package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception{
        FileInputStream fin = new FileInputStream(args[0]);

        TreeMap<Character, Integer> map = new TreeMap<>();
        Integer count;
        while (fin.available() > 0) {
            char ch = (char) fin.read();
            count = map.put(ch, 1);
            if(count != null) map.put(ch, count+1);
        }

        for(Map.Entry<Character, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }

        fin.close();
    }
}
