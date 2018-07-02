package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int A = 0;
        int B = 0;

        A = Integer.parseInt(reader.readLine());
        B = Integer.parseInt(reader.readLine());

        if(A<0 || B<0){
            throw new Exception();
        } else {

            do {
                if (A > B) A = A - B;
                else B = B - A;
            } while (A != B);
        }
        System.out.println(A);
    }
}
