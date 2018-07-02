package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

/* 
Нити и байты
*/

public class Solution {
    public static volatile Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();
        while (!("exit".equals(nameFile   = reader.readLine()))) {
            ReadThread rd = new ReadThread(nameFile);
            rd.start();
        }
    }

    public static class ReadThread extends Thread {
        String name;
        FileInputStream file;

        public ReadThread(String fileName) throws FileNotFoundException {
            super(fileName);
            file = new FileInputStream(fileName);
            this.name = fileName;
        }

        public void run() {
            ArrayList<Integer> list = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            try {
                while (file.available() > 0) {
                    list.add(file.read());
                }
                file.close();
                int count = 0;
                for (int ch : list) {
                    if (map.containsKey(ch)) {
                        map.put(ch, map.get(ch) + 1);
                    } else {
                        map.put(ch, 1);
                    }
                }
                int max = 0;
                int bytes = 0;

                for (Map.Entry<Integer, Integer> paitr : map.entrySet()) {
                    if (paitr.getValue() > max) {
                        max = paitr.getValue();
                        bytes = paitr.getKey();
                    }
                }
                resultMap.put(name, bytes);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}