package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            reader.close();

            FileReader fr = new FileReader(fileName1);
            FileWriter fw = new FileWriter(fileName2);

            BufferedReader reader1 = new BufferedReader(fr);
            BufferedWriter writer = new BufferedWriter(fw);

            int i;
            String str = "";
/*            while(reader1.ready()){
                i=reader1.read();
                Character ch = (char) i;
                if(Character.isDigit(ch)) {
                    str = str + ch;
                }
                else {
                    if(!str.equals("")) {
                        writer.write(str.toCharArray());
                        writer.write(' ');
                    }

                    str = "";
                }
            }*/

            while(reader1.ready()){
                i=reader1.read();
                Character ch = (char) i;
                if(ch != ' ') {
                    str = str + ch;
                }
                else {
                    if(!str.equals("")) {

                        try {
                            Integer.parseInt(str);
                            writer.write(str);
                            writer.write(' ');
                        } catch (IOException e) {

                        } catch (NumberFormatException e) {

                        }
                    }

                    str = "";
                }
            }

            reader1.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
