package com.javarush.task.task15.task1521;

import java.math.BigDecimal;
import java.math.BigInteger;

/* 
ООП. Перегрузка
*/

public class Solution {

    public static void main(String[] args) {
        BigInteger bg = new BigInteger("6516464167846165164613584316841321684");
        BigInteger bg1 = new BigInteger("1");


        System.out.println(bg.add(bg1.negate()));
        /*//Блок 2.
        //Вызов для Object
        new Tree().info((Object)new Integer("4"));
        new Tree().info((Object)new Short("4"));
        new Tree().info((Object)new BigDecimal("4"));

        //Блок 3.
        //Вызов для Number
        new Tree().info(new Integer("4"));
        new Tree().info(new Short("4"));
        new Tree().info(new BigDecimal("4"));

        //Блок 4.
        //Вызов для String
        new Tree().info(new String("4"));
        new Tree().info(new Integer("4").toString());
        new Tree().info(new Short("4").toString());
        new Tree().info(new BigDecimal("4").toString());*/
    }
}
