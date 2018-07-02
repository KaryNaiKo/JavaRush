package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException{
        if(string == null || countOfChar('\t', string) < 2) throw new TooShortStringException();
        String[] str = string.split("\t");

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 2; i++) {
            sb = sb.append(str[i]);
        }
        return sb.toString();

    }

    public static class TooShortStringException extends Exception {
    }

    public static int countOfChar(char ch, String str) {
        int count = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(ch == chars[i]) count++;
        }

        return count;
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
