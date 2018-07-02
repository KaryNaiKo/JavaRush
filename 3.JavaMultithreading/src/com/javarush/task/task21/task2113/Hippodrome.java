package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Павлуша on 12.10.2017.
 */
public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;
    
    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> hr) {
        horses = hr;
    }

    public void move() {
        for (int i = 0; i < horses.size() ; i++) {
            getHorses().get(i).move();
        }
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void print() {
        for (int i = 0; i < horses.size() ; i++) {
            getHorses().get(i).print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse winner = getHorses().get(0);
        for (int i = 0; i < getHorses().size()-1; i++) {
            if(getHorses().get(i).getDistance() < getHorses().get(i+1).getDistance()) winner = getHorses().get(i+1);
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) {
//        ArrayList<Horse> horses = new ArrayList<>();
//        horses.add(new Horse("Horse number 1", 3, 0));
//        horses.add(new Horse("Horse number 2", 3, 0));
//        horses.add(new Horse("Horse number 3", 3, 0));
//        game = new Hippodrome(horses);
//        game.run();
//        game.printWinner();

    }
}
