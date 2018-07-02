package com.javarush.task.task35.task3513;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * Created by Павлуша on 06.02.2018.
 * будет содержать игровую логику и хранить игровое поле.
 */
public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;

    int score = 0;
    int maxTile = 2;

    private Stack<Tile[][]> previousStates;
    private Stack<Integer> previousScores;
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
        previousScores = new Stack();
        previousStates = new Stack();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    private void addTile() {
        ArrayList<Tile> list = getEmptyTiles();

        if (!list.isEmpty()) {
            int indexOfAddTile = (int) ((double)list.size() * Math.random());

            Tile tile = list.get(indexOfAddTile);
            tile.value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    private ArrayList<Tile> getEmptyTiles() {
        ArrayList<Tile> list = new ArrayList();

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if(gameTiles[i][j].value == 0) list.add(gameTiles[i][j]);
            }
        }

        return list;
    }

    public void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }

        addTile();
        addTile();
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean changeIsMade = false;

        for (int j = 0; j < tiles.length; j++) {
            for (int i = 0; i < tiles.length-1; i++) {
                if(tiles[i].value == 0 && tiles[i+1].value != 0) {
                    swap(tiles[i], tiles[i+1]);
                    changeIsMade = true;
                }
            }
        }

        return changeIsMade;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean changeIsMade = false;
        int currentTileValue;

        for (int i = 0; i < tiles.length-1; i++) {
            //проверка, чтобы не складывать нули
            if(tiles[i].value == 0) break;

            if(tiles[i].value == tiles[i+1].value) {
                currentTileValue = tiles[i].value + tiles[i+1].value;
                score += currentTileValue;
                if(currentTileValue > maxTile) maxTile = currentTileValue;

                tiles[i].value = currentTileValue;
                tiles[i+1].value = 0;

                i++;
                changeIsMade = true;
            }
        }

        compressTiles(tiles);

        return changeIsMade;
    }

    private void swap(Tile tile, Tile tile1) {
        int temp;
        temp = tile.value;
        tile.value = tile1.value;
        tile1.value = temp;
    }

    public boolean canMove() {
        if (!getEmptyTiles().isEmpty()) {
            return true;
        }
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length - 1; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j + 1].value) {
                    return true;
                }
            }
        }
        for (int j = 0; j < gameTiles.length; j++) {
            for (int i = 0; i < gameTiles.length - 1; i++) {
                if (gameTiles[i][j].value == gameTiles[i + 1][j].value) {
                    return true;
                }
            }
        }
        return false;
    }

    public void left() {
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        boolean cond = false;

        for (int i = 0; i < gameTiles.length; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                cond = true;
            }
        }

        if(cond) addTile();
        isSaveNeeded = true;
    }

    public void right() {
        saveState(gameTiles);

        rotate180();
        left();
        rotate180();
    }

    public void down() {
        saveState(gameTiles);

        rotatePlus90();
        left();
        rotateMinus90();
    }

    public void up() {
        saveState(gameTiles);

        rotateMinus90();
        left();
        rotatePlus90();
    }

    private void rotateMinus90() {
        Tile[][] tempTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                tempTiles[FIELD_WIDTH-1-j][i] = new Tile(gameTiles[i][j].value);
            }
        }
        copyTiles(gameTiles, tempTiles);
    }

    private void rotate180() {
        Tile[][] tempTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                tempTiles[i][FIELD_WIDTH-1-j] = new Tile(gameTiles[i][j].value);
            }
        }
        copyTiles(gameTiles, tempTiles);
    }

    private void rotatePlus90() {
        Tile[][] tempTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                tempTiles[j][FIELD_WIDTH-1-i] = new Tile(gameTiles[i][j].value);
            }
        }
        copyTiles(gameTiles, tempTiles);
    }

    private void copyTiles(Tile[][] source, Tile[][] temp) {
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                source[i][j].value = temp[i][j].value;
            }
        }
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] copyTile = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                copyTile[i][j] = new Tile(gameTiles[i][j].value);
            }
        }
        previousStates.push(copyTile);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousScores.empty() & !previousStates.empty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public void randomMove() {
        int move = (int)(Math.random() * 100) % 4;

        switch (move) {
            case 0:
                up();
                break;
            case 1:
                right();
                break;
            case 2:
                down();
                break;
            case 3:
                left();
                break;
        }
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue<>(4, Collections.reverseOrder());

        queue.add(getMoveEfficiency(this::left));
        queue.add(getMoveEfficiency(this::right));
        queue.add(getMoveEfficiency(this::up));
        queue.add(getMoveEfficiency(this::down));

        queue.poll().getMove().move();
    }

    private boolean hasBoardChanged() {
        Tile[][] tempTiles = previousStates.peek();

        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                if(gameTiles[i][j].value != tempTiles[i][j].value) return true;
            }
        }

        return false;
    }

    private MoveEfficiency getMoveEfficiency(Move move) {

        move.move();

        MoveEfficiency moveEfficiency;
        if(!hasBoardChanged()) {
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        }
        else {
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        }

        rollback();
        return moveEfficiency;
    }

//
//    public static void main(String[] args) {
//        Model model = new Model();
//
//        System.out.println(model.score + " " + model.maxTile);
//
//        Tile[] tiles = new Tile[4];
//        tiles[0] = new Tile(4);
//        tiles[1] = new Tile(4);
//        tiles[2] = new Tile(4);
//        tiles[3] = new Tile(4);
//
//        for (int i = 0; i < 4; i++) {
//            System.out.print(tiles[i].value + " ");
//        }
//        System.out.println();
//
//        model.mergeTiles(tiles);
//
//        for (int i = 0; i < 4; i++) {
//            System.out.print(tiles[i].value + " ");
//        }
//        System.out.println();
//
//        System.out.println(model.score + " " + model.maxTile);
//    }

//    public static void main(String[] args) {
//        Model model = new Model();
//        int count = 0;
//        for (int i = 0; i < FIELD_WIDTH; i++) {
//            for (int j = 0; j < FIELD_WIDTH; j++) {
//                model.gameTiles[i][j].value = ++count;
//            }
//        }
//
//        for (int i = 0; i < FIELD_WIDTH; i++) {
//            for (int j = 0; j < FIELD_WIDTH; j++) {
//                System.out.print( "[" + model.gameTiles[i][j].value + "] ");
//            }
//            System.out.println();
//        }
//        System.out.println("////////////////////body///////////////////");
//        model.rotatePlus90();
//        System.out.println("////////////////////end///////////////////");
//
//        for (int i = 0; i < FIELD_WIDTH; i++) {
//            for (int j = 0; j < FIELD_WIDTH; j++) {
//                System.out.print( "[" + model.gameTiles[i][j].value + "] ");
//            }
//            System.out.println();
//        }
//    }
}
