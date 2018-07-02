package com.javarush.task.task28.task2813;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.*;

/* 
FutureTask
*/

public class Solution {
    private static final ExecutorService threadpool = Executors.newFixedThreadPool(4);
    private static final int n = 16;

    public static void main(String args[]) throws InterruptedException, ExecutionException {
        FactorialCalculator task = new FactorialCalculator(n);



        long startTime = System.currentTimeMillis();

        System.out.println("Submitting Task ...");
        Future future = threadpool.submit(task);
        System.out.println("Task was submitted successfully");

        while (!future.isDone()) {
            System.out.println("Task is not completed yet....");
            //Thread.sleep(1);
        }

        System.out.println("Task is completed, let's check the result");
        long factorial = (long) future.get();

        System.out.println("Factorial of " + n + " is : " + factorial);
        threadpool.shutdown();

        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println(timeSpent);

        System.out.println("||||||||||||||||||||||||||||||||||");
        startTime = System.currentTimeMillis();
        System.out.println("Result: " + task.factorial(16));
        timeSpent = System.currentTimeMillis() - startTime;
        System.out.println(timeSpent);
    }
}
