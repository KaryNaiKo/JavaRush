package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        HashMap<String, Cat> map = new HashMap<>();
        map.put("Имя1", new Cat("Имя1"));
        map.put("Имя2", new Cat("Имя2"));
        map.put("Имя3", new Cat("Имя3"));
        map.put("Имя4", new Cat("Имя4"));
        map.put("Имя5", new Cat("Имя5"));
        map.put("Имя6", new Cat("Имя6"));
        map.put("Имя7", new Cat("Имя7"));
        map.put("Имя8", new Cat("Имя8"));
        map.put("Имя9", new Cat("Имя9"));
        map.put("Имя10", new Cat("Имя10"));

        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        HashSet<Cat> set = new HashSet<>();
        for(Map.Entry<String, Cat> pair : map.entrySet()){
            set.add(pair.getValue());
        }

        return set;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
