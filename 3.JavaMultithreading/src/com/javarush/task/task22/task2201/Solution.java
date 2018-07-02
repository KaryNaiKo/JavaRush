package com.javarush.task.task22.task2201;

/* 
Строки нитей или строковые нити? Вот в чем вопрос
*/
public class Solution {
    public static void main(String[] args) {
        new Solution();
    }

    public static final String FIRST_THREAD_NAME = "1#";
    public static final String SECOND_THREAD_NAME = "2#";

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    public Solution() {
        initThreads();
    }

    protected void initThreads() {
        this.thread1 = new Thread(new Task(this, "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
        this.thread2 = new Thread(new Task(this, "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"), SECOND_THREAD_NAME);
        this.thread3 = new Thread(new Task(this, "\t\t"), "3#");

        Thread.setDefaultUncaughtExceptionHandler(new ThisUncaughtExceptionHandler());

        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
    }

    public synchronized String getPartOfString(String string, String threadName) {
//        if((countOfChar('\t', string) < 2) || (string==null)) {
//
//            if (Solution.FIRST_THREAD_NAME.equals(threadName)) {
//                throw new TooShortStringFirstThreadException();
//            } else
//            if (Solution.SECOND_THREAD_NAME.equals(threadName)) {
//                throw new TooShortStringSecondThreadException();
//            } else {
//                throw new RuntimeException();
//            }
//        }

        int firstTab = string.indexOf('\t');
        //System.out.println("firstTab = " + firstTab);
        int lastTab = string.lastIndexOf('\t');
        //System.out.println("lastTab = " + lastTab);

        try {
            return string.substring(firstTab+1, lastTab);
        } catch (Exception e) {
            if (Solution.FIRST_THREAD_NAME.equals(threadName)) {
                throw new TooShortStringFirstThreadException(e);
            } else
            if (Solution.SECOND_THREAD_NAME.equals(threadName)) {
                throw new TooShortStringSecondThreadException(e);
            } else {
                throw new RuntimeException(e);
            }
        }
        //return null;
    }

    public static int countOfChar(char ch, String str) {
        int count = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(ch == chars[i]) count++;
        }

        return count;
    }
}
