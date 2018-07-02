package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int countSeconds = 3;
    public static volatile boolean cond = false;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут
        Thread.sleep(3500);
        /*if(!cond)*/ clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
            Thread currentthread = Thread.currentThread();
            try {
                while (countSeconds > 0 /*&& !currentthread.isInterrupted()*/) {
                    System.out.print(countSeconds + " ");
//                    if(countSeconds != 0) System.out.print(countSeconds + " ");
//                    else System.out.print("Марш");
                    Thread.sleep(1000);
                    countSeconds--;

                }
                System.out.print("Марш!");
                cond = true;
            } catch (InterruptedException e) {
                System.out.print("Прервано!");
            }
        }
    }
}
