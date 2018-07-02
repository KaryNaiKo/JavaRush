package com.javarush.task.task25.task2511;

import java.util.TimerTask;

/* 
Вооружаемся до зубов!
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = new MyUncaughtExceptionHandler();    //init handler here
    }

    public void run() {
        try {

            original.run();
            throw new NullPointerException("Ouch");
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                //System.out.println(1);
            }
        };

        Solution solution = new Solution(timerTask);

        Thread thread = new Thread(solution);

        thread.start();
    }

    private class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            String threadName = t.getName();
            StringBuilder encryptedTheadName = new StringBuilder();
            for (int i = 0; i < threadName.length(); i++) {
                encryptedTheadName.append('*');
            }


            String str = e.getMessage();
            System.out.println(str.replace(t.getName(), encryptedTheadName));
        }
    }
}