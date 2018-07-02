package com.javarush.task.task32.task3206;

import java.lang.reflect.Proxy;
import java.util.*;

/* 
Дженерики для создания прокси-объекта
*/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        test(solution.getProxy(Item.class));                        //true false false
        test(solution.getProxy(Item.class, Small.class));           //true false true
        test(solution.getProxy(Item.class, Big.class, Small.class));//true true true
        test(solution.getProxy(Big.class, Small.class));            //true true true т.к. Big наследуется от Item
        test(solution.getProxy(Big.class));                         //true true false т.к. Big наследуется от Item
    }

    public Item getProxy(Class returnProxy, Class... interfases) {

        ArrayList<Class> list = new ArrayList<>();
        list.add(returnProxy);

        for (int i = 0; i < interfases.length; i++) {

            list.add(interfases[i]);
        }

        //System.out.println(list);

        return (Item) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                list.toArray(new Class[list.size()]),
                //returnProxy.getInterfaces(),
                new ItemInvocationHandler());
    }


    private static void test(Object proxy) {
        boolean isItem = proxy instanceof Item;
        boolean isBig = proxy instanceof Big;
        boolean isSmall = proxy instanceof Small;

        System.out.format("%b %b %b\n", isItem, isBig, isSmall);
    }


}