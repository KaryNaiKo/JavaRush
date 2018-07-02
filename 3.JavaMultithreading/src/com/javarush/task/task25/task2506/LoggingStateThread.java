package com.javarush.task.task25.task2506;

/**
 * Created by Павлуша on 07.12.2017.
 */
public class LoggingStateThread extends Thread{
    Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;

    }

    @Override
    public void run() {

        State state = State.WAITING;
        while (state != State.TERMINATED) {
            if(!state.equals(thread.getState())) {
                state = thread.getState();
                System.out.println(state);
            }
        }
    }
}
