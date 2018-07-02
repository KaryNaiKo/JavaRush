package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter  implements PersonScanner{
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner scanner) {
            fileScanner = scanner;
        }

        @Override
        public Person read() throws IOException {
            String str = "";
            if(fileScanner.hasNextInt()) {
                str = fileScanner.nextLine();
            }
            String[] strSplit = str.split(" ");
            Date dt = new Date(Integer.parseInt(strSplit[5]), Integer.parseInt(strSplit[4]), Integer.parseInt(strSplit[3]));
            return new Person(strSplit[1], strSplit[2], strSplit[0], dt);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
