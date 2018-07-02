package com.javarush.task.task30.task3013;

/* 
Набираем код
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //int number = Integer.MAX_VALUE - 133;
        int number = 123123;
        System.out.println(Integer.toString(number, 2));

        String result = Integer.toString(solution.resetLowerBits(number), 2);
        System.out.println(result);
    }

    public int resetLowerBits(int number) {
        //напишите тут ваш код
        int i = 60;
        System.out.println(Integer.toString(i, 2));
        System.out.println(Integer.toString(i << 1, 2));
        System.out.println(i<<1);

        return 0;
    }
}