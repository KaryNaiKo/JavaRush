package com.javarush.task.task22.task2202;

import java.util.ArrayList;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) throws Exception{
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java"));
    }

    public static String getPartOfString(String string) throws TooShortStringException{
        if(string == null) throw new TooShortStringException();
        String[] str = string.split(" ");
        if(str.length < 5) throw new TooShortStringException();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 5; i++) {
             sb = sb.append(str[i]).append(' ');
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    public static class TooShortStringException extends RuntimeException{
    }

}
