package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.*;

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }
    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        for(int i=off; len >= 0; i++, len--){
            System.out.print(cbuf[i]);
        }
    }
    public void write(int c) throws IOException {

    }
    public void write(String str) throws IOException {

    }
    public void write(String str, int off, int len) {

    }
    public void write(char[] cbuf) throws IOException {

    }
    public void close() throws IOException {

    }


    public static void main(String[] args) throws Exception{

    }

}
