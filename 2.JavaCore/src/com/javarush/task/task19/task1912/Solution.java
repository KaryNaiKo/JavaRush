package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
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


        System.out.print(result.replaceAll("te", "??"));

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
