package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


/* 
Что внутри папки?
*/
public class Solution extends SimpleFileVisitor<Path>{
    private int countOfFolder;
    private int countOfFiles;
    private int totalSize;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        if(Files.isDirectory(Paths.get(str))) {
            Solution solution = new Solution();
            Files.walkFileTree(Paths.get(str), solution);

            System.out.println("Всего папок - " + (solution.countOfFolder-1));
            System.out.println("Всего файлов - " + solution.countOfFiles);
            System.out.println("Общий размер - " + solution.totalSize);
        } else {
            System.out.println(str + " - не папка");
        }
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

        if(Files.isDirectory(dir)) {
            countOfFolder++;
        }

        return super.preVisitDirectory(dir, attrs);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file);
        totalSize += content.length;

        if(Files.isRegularFile(file)) {
            countOfFiles++;
        }

        return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult visitFileFailed(Path path, IOException exc) throws IOException {

        return FileVisitResult.SKIP_SUBTREE;
    }
}
