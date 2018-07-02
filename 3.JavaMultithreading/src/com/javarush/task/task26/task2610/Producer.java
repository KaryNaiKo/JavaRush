package com.javarush.task.task26.task2610;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private ArrayQueue queue;

    public Producer(ArrayQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            int i = 0;
            while (true) {
                queue.add(String.valueOf(i++));
                Thread.sleep(200);
            }
        } catch (Exception e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}