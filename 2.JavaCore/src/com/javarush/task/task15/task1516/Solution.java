package com.javarush.task.task15.task1516;

/* 
Значения по умолчанию
*/

public class Solution {

    public  int intVar = 0;
    public  double doubleVar = 0;
    public  Double DoubleVar = 0d;
    public  boolean booleanVar = false;
    public  Object ObjectVar = null;
    public  Exception ExceptionVar = null;
    public  String StringVar = null;

    public static void main(String[] args) {

        Solution s = new Solution();

        System.out.println(s.intVar);
        System.out.println(s.doubleVar);
        System.out.println(s.DoubleVar);
        System.out.println(s.booleanVar);
        System.out.println(s.ObjectVar);
        System.out.println(s.ExceptionVar);
        System.out.println(s.StringVar);
    }
}
