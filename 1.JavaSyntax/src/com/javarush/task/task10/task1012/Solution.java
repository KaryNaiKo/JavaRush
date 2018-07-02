package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }



        // напишите тут ваш код
        for(Character ch : alphabet){                                           //перебрали алфавит
            int count = 0;
            for(String string : list){                                                 //перебрали строки введенные с клавиатуры
                char[] chars = string.toCharArray();                        //каждую строку разбираем на массив
                for(char c : chars){                                                  //перебираем массив
                    if(ch == c){
                        count++;
                    }
                }
            }
            System.out.println(ch + " " + count);
        }


/*        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<abcArray.length; i++){
            map.put(abcArray[i], 0);
        }
        for(String str : list){
            for(  Map.Entry<Character, Integer> entry : map.entrySet()) {
                char[] ch = str.toCharArray();
                for (int i = 0; i < ch.length; i++) {
                    if (entry.getKey().equals(ch[i])) entry.setValue(entry.getValue()+1);
                }
            }
        }

        for(  Map.Entry<Character, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }*/
    }

}
