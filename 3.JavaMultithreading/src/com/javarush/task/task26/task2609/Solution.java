package com.javarush.task.task26.task2609;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/*
Распределение элементов по корзинам с собственным локом
*/
public class Solution {
    private static final int NUMBER_LOCKS = 12;
    private final Node[] buckets;
    private final Object[] locks;

    static class Node {
        public Node next;
        public Object key;
        public Object value;
    }

    public Solution(int numberBuckets) {
        buckets = new Node[numberBuckets];
        locks = new Object[NUMBER_LOCKS];
        for (int i = 0; i < NUMBER_LOCKS; i++) {
            locks[i] = new Object();
        }
        //ConcurrentHashMapHashMap
    }

    private final int hash(Object key) {
        System.out.println(key.hashCode() % buckets.length);
        return Math.abs(key.hashCode() % buckets.length);
    }

    public Object get(Object key) {
        int hash = hash(key);
        synchronized (locks[hash % NUMBER_LOCKS]) {
            for (Node m = buckets[hash]; m != null; m = m.next) {
                if (m.key.equals(key)) return m.value;
            }
        }
        return null;
    }

    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            synchronized (locks[i % NUMBER_LOCKS] ) {
                buckets[i] = null;
            }
        }
    }

    public static void main(String[] args) {
//        Solution solution = new Solution(7);
//
//        Object one = new Object();
//        Object two = new Object();
//        Object three = new Object();
//        Object four = new Object();
//        Object five = new Object();
//
//        System.out.println(one.hashCode());
//        System.out.println(two.hashCode());
//        System.out.println(three.hashCode());
//
//        solution.hash(one);
//        solution.hash(two);
//        solution.hash(three);
//        solution.hash(four);
//        solution.hash(five);

    }
}
