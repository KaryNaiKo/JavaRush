package com.javarush.task.task33.task3310;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by Павлуша on 22.04.2018.
 */
public class Test {
    Path path = Paths.get("D:\\test.dat");

    public static void main(String[] args) throws Exception{
        if(!Files.exists(Paths.get("D:\\test.dat"))) {
            Files.createFile(Paths.get("D:\\test.dat"));
        }

        TestCube cube1 = new TestCube(1, 2, 3, null);
        TestCube cube2 = new TestCube(1, 2, 3, cube1);
        TestCube cube3 = new TestCube(1, 2, 3, cube2);

        System.out.println(cube1);
        System.out.println("=========");
        System.out.println(cube2);
        System.out.println("=========");
        System.out.println(cube3);

        Test test = new Test();
        test.write(cube3);

        TestCube cube4 = test.ser(1);

        System.out.println(cube4);
    }

    private void write(TestCube cube) throws Exception{
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(Paths.get("D:\\test.dat").toFile(), true));
        objectOutputStream.writeObject(cube);
    }

    private TestCube ser(int count) throws Exception {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path.toFile()));

        TestCube testCube = null;
            for (int i = 0; i < count; i++) {
            testCube = (TestCube) objectInputStream.readObject();
        }

        return testCube;
    }
}

//144 байт