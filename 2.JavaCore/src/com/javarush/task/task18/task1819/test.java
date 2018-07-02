package com.javarush.task.task18.task1819;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Павлуша on 24.08.2017.
 */
public class test {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            FileInputStream fin = new FileInputStream(reader.readLine());

            System.out.println((char)fin.read());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
