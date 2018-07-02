package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        try {
            PrintStream consoleStream = System.out;

            //Создаем поток того же типа, что и настоящий. Его задачей будет перехват вывода и записи его в переменную
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream stream = new PrintStream(outputStream);
            //Установили (подменили) переменную out - stream
            System.setOut(stream);

            //Вызвали метод для вывода информации на  консоль, но вместо консоли данные отправляются с поток
            testString.printSomething();

            //Данные из потока обьеденяем в строку
            String result = outputStream.toString();

            //Возвращаем настоящий поток пока не спалили контору
            System.setOut(consoleStream);

            //Вывели на экран что хотели


            char[] charArray = result.toCharArray();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();

            FileOutputStream fos = new FileOutputStream(fileName);

            fos.write(result.getBytes());
            System.out.print(result);

            reader.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

