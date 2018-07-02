package com.javarush.task.task20.task2025;

import java.lang.reflect.Array;
import java.util.ArrayList;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        ArrayList<Long> list = new ArrayList<>();
        long temp;
        int countOfNumbers = 1;
        while (N>0){
            temp = N;
            while((temp=temp/10) > 0) {
                countOfNumbers++;
            }

            String str = Long.toString(N);
            char[] chars = str.toCharArray();
            int a=0;
            long sum=0;
            for(int i=0; i<chars.length; i++) {
                a = Integer.parseInt(String.valueOf(chars[i]));
                if((sum += Math.pow(a, countOfNumbers)) > N) break;
            }
            if(sum == N) list.add(N);
            countOfNumbers=1;
            N--;
        }


        long[] result = new long[list.size()];
        for(int i=0; i<list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        long lg[] = getNumbers(	922337123L);
        for(int i=0; i<lg.length; i++) {
            System.out.println(lg[i]);
        }

    }
}
