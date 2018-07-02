package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private int age;
        private int weight;
        private String name;
        private String address;
        private Human parent;
        private Human childrens;

        public Human(int age){
            this.age = age;
        }
        public Human(int age, int weight){
            this.age = age;
            this.weight = weight;
        }

        public Human(int age, int weight, String name){
            this.age = age;
            this.weight = weight;
            this.name = name;
        }
        public Human(int age, int weight, String name, String address){
            this.age = age;
            this.weight = weight;
            this.name = name;
            this.address = address;
        }
        public Human(int age, int weight, String name, String address, Human parent){
            this.age = age;
            this.weight = weight;
            this.name = name;
            this.address = address;
            this.parent = parent;
        }
        public Human(int age, int weight, String name, String address, Human parent, Human childrens){
            this.age = age;
            this.weight = weight;
            this.name = name;
            this.address = address;
            this.parent = parent;
            this.childrens = childrens;
        }
        public Human(int age, String name, String address, Human parent){
            this.age = age;
            this.name = name;
            this.address = address;
            this.parent = parent;
        }
        public Human(int age, int weight,  String address, Human parent){
            this.age = age;
            this.weight = weight;
            this.address = address;
            this.parent = parent;
        }
        public Human( Human parent){
            this.parent = parent;
        }
        public Human( String name){
            this.name = name;
        }

    }
}
