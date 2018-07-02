package com.javarush.task.task31.task3112;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        URL url = new URL(urlString);
        String[] fileName = url.getFile().split("/");
        String name = (fileName[fileName.length-1]);
//        String name = url.getFile();
        InputStream inputStream = url.openStream();

        Path tempFile = Files.createTempFile("temp-",".tmp");
        Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);

        Path outputFile = Paths.get(downloadDirectory.toString(), name);
        //Path outputFile = Paths.get(downloadDirectory.toString() + "/" + fileName);
        if(!Files.exists(outputFile)) {
            Files.createDirectory(outputFile.getParent());
            Files.createFile(outputFile);
        }

        Path path = Files.move(tempFile, outputFile);

        return path;
    }
}
