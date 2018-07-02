package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

import java.lang.reflect.Array;
import java.util.ArrayList;

public class VeryComplexClass {
    public void methodThrowsClassCastException() throws ClassCastException {
        Object x = new Integer(0);
        System.out.println((String)x);
    }

    public void methodThrowsNullPointerException() throws NullPointerException {
        ArrayList<Integer> list = null;
        list.add(1);
    }

    public static void main(String[] args) {
        VeryComplexClass complexClass = new VeryComplexClass();
        complexClass.methodThrowsNullPointerException();
    }
}
