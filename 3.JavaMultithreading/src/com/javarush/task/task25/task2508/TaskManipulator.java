package com.javarush.task.task25.task2508;

import java.util.ArrayList;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;

    @Override
    public void run() {
        try { // Если interrupt() был вызван до выполнения Thread.sleep(100), вызывается try-catch и завершается трэд.
            while (!thread.currentThread().isInterrupted()) { // Проверка на прерывание если interrupt() был вызван во время выполнения Thread.sleep(100), и завершается трэд.
                System.out.println(thread.currentThread().getName());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void start(String threadName) {
        Thread thread = new Thread(this, threadName);
        this.thread = thread;
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
