package com.javarush.task.task31.task3110.exception;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Павлуша on 22.12.2017.
 */
public class Test {
    private static Path rootPath = Paths.get("D:\\ForTests");
    private static Path rootPath2 = Paths.get("D:\\ForTests\\Chat\\переписка.txt");
    private static Path rootPath3 = Paths.get("test\\123\\");
    private static  List<Path> fileList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(rootPath.resolve(rootPath2));
        System.out.println(rootPath2.resolve(rootPath));
        System.out.println(rootPath2.resolve(rootPath3));
    }

}

//public class ZipFileManager {
//    private Path zipFile;
//
//    public ZipFileManager(Path zipFile) {
//        this.zipFile = zipFile;
//    }
//
//    public void createZip(Path source) throws Exception {
//        try (ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(zipFile));
//             InputStream inputStream = Files.newInputStream(source)) {
//
//            ZipEntry zipEntry = new ZipEntry(source.getFileName().toString());
//            zos.putNextEntry(zipEntry);
//
//            while (inputStream.available() > 0) {
//                zos.write(inputStream.read());
//            }
//        }
//    }
//}
