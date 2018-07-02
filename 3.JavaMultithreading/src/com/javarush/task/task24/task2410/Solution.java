package com.javarush.task.task24.task2410;

import java.util.LinkedList;
import java.util.List;

/* 
Рефакторинг, анонимные классы
*/
public class Solution {
    public static List<Iterator> iterators = new LinkedList<>();

    private int countItems;

    public Iterator getIterator(final String name) {
        countItems++;
        System.out.println(name + " item " + countItems);

        return new Iterator() {

            @Override
            public Iterator next() {
                return getIterator(name);
            }
        };
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Iterator iterator = solution.getIterator("iterator");
        for (int i = 1; i < 5; i++) {
            iterators.add(iterator.next());
        }
    }
}


/*
        iterator item 1
        iterator item 2
        iterator item 3
        iterator item 4
        iterator item 5*/
