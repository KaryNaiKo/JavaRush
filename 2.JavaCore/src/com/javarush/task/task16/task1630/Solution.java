package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        System.out.println();
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.print(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут

    public static class ReadFileThread extends Thread implements ReadFileInterface {

        FileInputStream fstr;

        @Override
        public void setFileName(String fullFileName) {
            try {
                 fstr = new FileInputStream(fullFileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String getFileContent() {
            String str_t =  "";
            String str = "";
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(fstr));

                while((str_t = reader.readLine()) != null ) {
                    str = str + str_t + " ";
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return str;
        }

        @Override
        public void start() {

        }

        @Override
        public void run() {

            getFileContent();
            try {
                fstr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
