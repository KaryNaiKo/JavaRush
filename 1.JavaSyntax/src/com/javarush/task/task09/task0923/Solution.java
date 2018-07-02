package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Character> vowels_cahrs = new ArrayList<>();
        ArrayList<Character> consonans_cahrs = new ArrayList<>();

        String str = reader.readLine();
        char [] chars = str.toCharArray();
        for(char ch : chars) {
            if(isVowel(ch)) vowels_cahrs.add(ch);
            else if(ch != ' ') consonans_cahrs.add(ch);
        }

        str = "";
        for(char ch : vowels_cahrs){
            str += ch + " ";
        }
        System.out.println(str);

        str = "";
        for(char ch : consonans_cahrs){
            str += ch + " ";
        }
        System.out.println(str);
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}