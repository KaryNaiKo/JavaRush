package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fis = new FileInputStream(fileName);
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(fis));

        ArrayList<String> list = new ArrayList<>();
        while (fileReader.ready()) {
            list.addAll(Arrays.asList(fileReader.readLine().split(" ")));
        }

        System.out.println(list);

//        for (int i = 0; i < list.size(); i++) {
//            StringBuilder sb = new StringBuilder(list.get(i));
//            String str = sb.reverse().toString();
//            if(list.contains(str)) {
//                if(!result.contains(new Pair(list.get(i), str)) && !result.contains(new Pair(str, list.get(i))))
//                    //System.out.println(list.get(i) + " = " + str);
//                    result.add(new Pair(list.get(i), str));
//            }
//        }
//        reader.close();
//        fileReader.close();
//
//        for (int i = 0; i < result.size(); i++) {
//            System.out.println(result.get(i));
//        }
        for (int i = 0; i < list.size(); i++)
            for (int j = 0; j < list.size();) {
                String
                        firstThis = list.get(i), //параметр для реверса
                        secondThis = list.get(j);

                //Загнали в кэш реверс первого и сравниваем
                if (i != j && new StringBuilder(firstThis).reverse().toString().equals(secondThis)) {
                    Pair pair = new Pair();
                    pair.first = firstThis;
                    pair.second = secondThis;

                    //Делаем пару, удаляем слова и возвращаем каретку в начало
                    result.add(pair);
                    list.remove(j); // индекс больше - удаляем первым - избегаем смещения
                    list.remove(i);
                    j = 0;
                }
                //А иначе двигаем каретку дальше
                else j++;
            }
    }

    public static class Pair {
        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        public Pair() {
            this.first = null;
            this.second = null;
        }

        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
