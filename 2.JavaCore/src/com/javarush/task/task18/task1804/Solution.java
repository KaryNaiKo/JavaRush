package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.*;

/*
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fIn = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());

        int countOfCoincidence = 0;
        Integer max = 100;
        Integer temp;
        int temp1;

        HashMap<Byte, Integer> map = new HashMap<>();

        while (fIn.available() > 0){
            temp1 = fIn.read();
            temp = map.put((byte)temp1, 1);
            if(temp != null) map.put((byte)temp1, temp+1);
        }

        for (Map.Entry<Byte, Integer> pair : map.entrySet()) {
            if(max > pair.getValue()) max = pair.getValue();
        }
        for (Map.Entry<Byte, Integer> pair : map.entrySet()) {
            if(pair.getValue() == max) System.out.print(pair.getKey() + " ");
        }

        fIn.close();
    }
}
