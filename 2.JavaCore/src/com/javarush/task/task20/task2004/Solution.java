package com.javarush.task.task20.task2004;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* 
Читаем и пишем в файл статики
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File your_file_name = new File("D:\\c++\\test1.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            ClassWithStatic classWithStatic = new ClassWithStatic();
            classWithStatic.i = 3;
            classWithStatic.j = 4;
            classWithStatic.save(outputStream);
            outputStream.flush();

            ClassWithStatic loadedObject = new ClassWithStatic();
            loadedObject.staticString = "something";
            loadedObject.i = 6;
            loadedObject.j = 7;

            //loadedObject.load(inputStream);
            loadedObject.save(outputStream);
            //check here that classWithStatic object equals to loadedObject object - проверьте тут, что classWithStatic и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class ClassWithStatic {
        public static String staticString = "it's test static string";
        public int i;
        public int j;

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
//            Class c = new ClassWithStatic().getClass();
//            Field[] f = c.getFields();
//            writer.write(Integer.toString(f.length));
//            writer.newLine();
            writer.write(staticString);
            writer.newLine();
            writer.write(Integer.toString(i));
            writer.newLine();
            writer.write(Integer.toString(j));
            writer.newLine();
            writer.flush();
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String str = "";

//            Class c = new ClassWithStatic().getClass();
//            Field[] f = c.getFields();
//            int i = Integer.parseInt(reader.readLine());
//
//            for (Field field : f) {
//                Class fieldType = field.getType();
//                System.out.println("Имя: " + field.getName());
//                System.out.println("Тип: " + fieldType.getName());
//            }
            staticString = reader.readLine();
            i = Integer.parseInt(reader.readLine());
            j = Integer.parseInt(reader.readLine());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ClassWithStatic that = (ClassWithStatic) o;

            if (i != that.i) return false;
            return j == that.j;

        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }
    }
}
