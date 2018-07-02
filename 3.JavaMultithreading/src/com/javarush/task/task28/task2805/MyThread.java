package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Павлуша on 01.02.2018.
 */
public class MyThread extends Thread{
    private static AtomicInteger priority = new AtomicInteger(1);

    public MyThread() {
        super();
        setPriority();
    }

    public MyThread(Runnable target) {
        super(target);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setPriority();
    }

    public MyThread(String name) {
        super(name);
        setPriority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setPriority();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setPriority();
    }

    private void setPriority() {
        int prt = priority.getAndIncrement();
        if(prt > 10) {
            prt = 1;
            priority.set(2);
        }
        if(getThreadGroup() != null) {
            setPriority(prt);
        } else {
            int max = getThreadGroup().getMaxPriority();
            if(prt > max) {
                setPriority(max);
            } else {
                setPriority(prt);
            }
        }
    }
}
