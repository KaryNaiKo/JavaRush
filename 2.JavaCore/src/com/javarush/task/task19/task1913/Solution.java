package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
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
        for(int i=0; i<result.length(); i++){
            if(Character.isDigit(result.charAt(i))) {
                str = str + result.charAt(i);
            }
        }
        System.out.print(str);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
