package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/* 
Находим все файлы
*/
public class Solution {
    private static Queue<File> queue = new ArrayBlockingQueue<File>(1000);


    public static List<String> getFileTree(String root) throws IOException {
        File file = new File(root);
        List<String> list = new ArrayList<>();
        if(file.isDirectory()) {
            queue.add(file);
            File currentDirectory;
            while (!queue.isEmpty()) {
                currentDirectory = queue.poll();
                File[] pathArray = currentDirectory.listFiles();

                if (pathArray != null) {
                    for (File entry: pathArray) {
                        if(entry.isDirectory()) queue.add(entry);
                        else {
                            list.add(entry.getAbsolutePath());
                        }
                    }
                }
            }
        }

        return list;
    }

    public static void main(String[] args) throws Exception{
        //System.out.println(getFileTree("F:\\"));
    }
}
