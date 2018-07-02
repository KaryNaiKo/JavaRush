package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/


public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {

        if(c.isAnnotationPresent(PrepareMyTest.class)) {
            PrepareMyTest myTest = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);

            String[] strings = myTest.fullyQualifiedNames();

            for (int i = 0; i < strings.length; i++) {
                System.out.println(strings[i]);
            }

            return true;
        }

        return false;
    }

    public static boolean printValues(Class c) {
        if(c.isAnnotationPresent(PrepareMyTest.class)) {
            PrepareMyTest myTest = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);

            Class<?>[] values = myTest.value();

            for (int i = 0; i < values.length; i++) {
                System.out.println(values[i]);
            }
            return true;
        }

        return false;
    }
}
