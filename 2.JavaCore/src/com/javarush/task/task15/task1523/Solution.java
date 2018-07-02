package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    public static int asd;
    public static void main(String[] args) {

    }

    private Solution(){
        asd = 10;
    }

    Solution(int asd){
        this.asd = asd ;
    }

    protected Solution(Integer i){
        asd = i;
    }

    public Solution(double d){
        asd = (int)d;
    }

}

