package com.javarush.task.task26.task2610;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Павлуша on 20.12.2017.
 */
public class Consumer implements Runnable {
    private ArrayQueue queue;

    public Consumer(ArrayQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(queue.remove(0));
                Thread.sleep(300);
            }
        } catch (Exception e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
