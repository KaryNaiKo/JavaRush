package com.javarush.task.task19.task1914;

/* 
Решаем пример
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

        String str = "";
        //char[] charArray = result.toCharArray();

        String[] tmp = result.split(" ");

        int
                a = Integer.valueOf(tmp[0]),
                b = Integer.valueOf(tmp[2]),
                c = 0;

        switch (tmp[1]) {
            case "+": c = a + b; break;
            case "-": c = a - b; break;
            case "*": c = a * b; break;
        }
        System.out.print(a + " " + tmp[1] + " " + b + " " + tmp[3] + " " + c);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

