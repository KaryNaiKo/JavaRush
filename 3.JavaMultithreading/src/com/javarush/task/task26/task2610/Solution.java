package com.javarush.task.task26.task2610;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* 
Мир скучен для скучных людей
*/
public class Solution {

    public static void main(String[] args) throws Exception {

        //BlockingQueue queue = new ArrayBlockingQueue(32, false);
        ArrayQueue queue = new ArrayQueue(32);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(producer);
        executorService.submit(consumer);

        Thread.sleep(10000);
        System.out.println(queue);
        executorService.shutdownNow();

    }
}
