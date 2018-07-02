package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/*
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fIn = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());

        Integer max = 100;
        Integer temp;
        int temp1;

        TreeSet<Byte> map = new TreeSet<>();

        while (fIn.available() > 0){

            map.add((byte)fIn.read());
        }
        for(Byte value : map) {
            System.out.print(value + " ");
        }
        fIn.close();
    }
}
