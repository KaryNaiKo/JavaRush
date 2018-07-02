package com.javarush.task.task37.task3712;

/**
 * Created by Павлуша on 25.04.2018.
 */
public abstract class Game {
     abstract void prepareForTheGame();

     abstract void playGame();

     abstract void congratulateWinner();

     public void run() {
          prepareForTheGame();
          playGame();
          congratulateWinner();
     }
}
