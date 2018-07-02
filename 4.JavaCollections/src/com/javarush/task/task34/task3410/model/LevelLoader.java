package com.javarush.task.task34.task3410.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Павлуша on 13.05.2018.
 */
public class LevelLoader {
    private Path levels;
    private ArrayList<Level> levelsFromTxt = new ArrayList<>();

    public LevelLoader(Path levels) {
        this.levels = levels;
        getLevels();
    }
    //Символ
// 'X' - означает стену,
// '*' - ящик,
// '.' - дом,
// '&' - ящик который стоит в доме,
// '@' - игрока.
    public GameObjects getLevel(int level) {
        level = level % 60;
        if(level == 0) level = 60;
        Player player = null;

        HashSet<Home> homes = new HashSet<>();
        HashSet<Box> boxes = new HashSet<>();
        HashSet<Wall> walls = new HashSet<>();

        Level levelFromArray = levelsFromTxt.get(level - 1);
        char[][] map = levelFromArray.getMap();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                switch (map[i][j]) {
                    case 'X' :
                        walls.add(new Wall(j*Model.FIELD_CELL_SIZE + Model.FIELD_CELL_SIZE/2,
                                i*Model.FIELD_CELL_SIZE + Model.FIELD_CELL_SIZE/2));
                        break;
                    case '*' :
                        boxes.add(new Box(j*Model.FIELD_CELL_SIZE + Model.FIELD_CELL_SIZE/2,
                                i*Model.FIELD_CELL_SIZE + Model.FIELD_CELL_SIZE/2));
                        break;
                    case '.' :
                        homes.add(new Home(j*Model.FIELD_CELL_SIZE + Model.FIELD_CELL_SIZE/2,
                                i*Model.FIELD_CELL_SIZE + Model.FIELD_CELL_SIZE/2));
                        break;
                    case '&' :
                        boxes.add(new Box(j*Model.FIELD_CELL_SIZE + Model.FIELD_CELL_SIZE/2,
                                i*Model.FIELD_CELL_SIZE + Model.FIELD_CELL_SIZE/2));
                        homes.add(new Home(j*Model.FIELD_CELL_SIZE + Model.FIELD_CELL_SIZE/2,
                                i*Model.FIELD_CELL_SIZE + Model.FIELD_CELL_SIZE/2));
                        break;
                    case '@' :
                        player = new Player(j*Model.FIELD_CELL_SIZE + Model.FIELD_CELL_SIZE/2,
                                i*Model.FIELD_CELL_SIZE + Model.FIELD_CELL_SIZE/2);
                        break;
                }
            }
        }

        GameObjects objects= new GameObjects(walls, boxes, homes, player);
        return  objects;
    }

    private void getLevels() {
        String delimiter = "*************************************";
        int coutOfLevels = 1;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(levels.toFile()));

            while (coutOfLevels <= 60) {
                String str = reader.readLine();
                if(!str.equals(delimiter)) throw new Error();

                int maze = Integer.parseInt(reader.readLine().split(" ")[1]);
                String fileOffset = reader.readLine();
                int sizeX = Integer.parseInt(reader.readLine().split(" ")[2]);
                int sizeY = Integer.parseInt(reader.readLine().split(" ")[2]);
                String end = reader.readLine();
                int length = Integer.parseInt(reader.readLine().split(" ")[1]);

                str = reader.readLine();
                if(!str.equals("")) throw new Error();

                Level level = new Level(maze, fileOffset, sizeX, sizeY, end, length);
                char[][] map = level.getMap();
                for (int i = 0; i < sizeY; i++) {
                    str = reader.readLine();
                    map[i] = str.toCharArray();
                }

                str = reader.readLine();
                if(!str.equals("")) throw new Error();

                levelsFromTxt.add(level);
                coutOfLevels++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class Level {
        private int maze;
        private String fileOffset;
        private int sizeX;
        private int sizeY;
        private String end;
        private int length;
        private char[][] map;

        public Level(int maze, String fileOffset, int sizeX, int sizeY, String end, int length) {
            this.maze = maze;
            this.fileOffset = fileOffset;
            this.sizeX = sizeX;
            this.sizeY = sizeY;
            this.end = end;
            this.length = length;
            map = new char[sizeY][sizeX];
        }

        public int getMaze() {
            return maze;
        }

        public String getFileOffset() {
            return fileOffset;
        }

        public int getSizeX() {
            return sizeX;
        }

        public int getSizeY() {
            return sizeY;
        }

        public String getEnd() {
            return end;
        }

        public int getLength() {
            return length;
        }

        public char[][] getMap() {
            return map;
        }

        public void setMap(char[][] map) {
            this.map = map;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("maze: " + maze + "\n");
            stringBuilder.append("sizeX: " + sizeX + "\n");
            stringBuilder.append("sizeY: " + sizeY + "\n");
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    stringBuilder.append(map[i][j]);
                }
                stringBuilder.append('\n');
            }
            return stringBuilder.toString();
        }
    }
//
//    public static void main(String[] args) {
////        LevelLoader levelLoader = new LevelLoader(Paths.get("4.JavaCollections/src/com/javarush/task/task34/task3410/res/levels.txt"));
////        levelLoader.getLevels();
////
////        for (int i = 0; i < levelLoader.levelsFromTxt.size(); i++) {
////            System.out.println(levelLoader.levelsFromTxt.get(i));
////            System.out.println();
////        }
//
//    }
}
