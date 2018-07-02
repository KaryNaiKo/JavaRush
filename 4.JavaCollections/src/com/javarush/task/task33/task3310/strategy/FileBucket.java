package com.javarush.task.task33.task3310.strategy;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    private Path path;

    public FileBucket(){
        try {
            path = Files.createTempFile(null, null);
            Files.deleteIfExists(path);
            Files.createFile(path);
            path.toFile().deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long getFileSize() {
        long size = 0;
        try {
            size = Files.size(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return size;
    }

    public void putEntry(Entry entry) {
        try {
            ObjectOutputStream stream = new ObjectOutputStream(Files.newOutputStream(path));
            stream.writeObject(entry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Entry getEntry() {
        if(getFileSize() == 0) return null;
        else {
            try {
                ObjectInputStream stream = new ObjectInputStream(Files.newInputStream(path));
                return (Entry) stream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




//package com.javarush.task.task33.task3310.strategy;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardOpenOption;
//
///**
// * Created by Павлуша on 19.04.2018.
// */
//public class FileBucket {
//    private Path path;
//    private int countOfEntryes;
//    private int seek;
//
//    public FileBucket(){
//        try {
//            path = Files.createTempFile(null, null);
//            Files.deleteIfExists(path);
//            Files.createFile(path);
//            path.toFile().deleteOnExit();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public int getSeek() {
//        return seek;
//    }
//
//    public void setSeek(int seek) {
//        this.seek = seek;
//    }
//
//    public int getCountOfEntryes() {
//        return countOfEntryes;
//    }
//
//    public void setCountOfEntryes(int countOfEntryes) {
//        this.countOfEntryes = countOfEntryes;
//    }
//
//    public long getFileSize() {
//        long size = 0;
//        try {
//            size = Files.size(path);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return size;
//    }
//
//    public void putEntry(Entry entry) {
//        try {
//            ObjectOutputStream stream = new ObjectOutputStream(Files.newOutputStream(path, StandardOpenOption.APPEND));
//            stream.writeObject(entry);
//            countOfEntryes++;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public Entry getEntry() {
//        if(getFileSize() == 0) return null;
//        else {
//            try {
//                ObjectInputStream stream = new ObjectInputStream(Files.newInputStream(path));
//                Entry entry = null;
//
//                for (int i = 0; i < seek; i++) {
//                    entry = (Entry) stream.readObject();
//                }
//
//                return entry;
//            } catch (IOException | ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }
//// Был
////    public Entry getEntry() {
////        if(getFileSize() == 0) return null;
////        else {
////            try {
////                ObjectInputStream stream = new ObjectInputStream(Files.newInputStream(path));
////                Entry entry = null;
////
//////                for (int i = 0; i < seek; i++) {
////                entry = (Entry) stream.readObject();
//////                }
////
////                return entry;
////            } catch (IOException | ClassNotFoundException e) {
////                e.printStackTrace();
////            }
////        }
////        return null;
////    }
//
//    public void remove() {
//        try {
//            Files.delete(path);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//
//
///*
//
//
// */