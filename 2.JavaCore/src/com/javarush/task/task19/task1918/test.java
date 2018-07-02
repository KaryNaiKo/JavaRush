package com.javarush.task.task19.task1918;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * Created by Павлуша on 19.09.2017.
 */
public class test {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileReader reade1 = new FileReader(reader.readLine());

        while (reade1.ready()) {
            System.out.print((reade1.read()));
            System.out.print(' ');
    }
    }
}
