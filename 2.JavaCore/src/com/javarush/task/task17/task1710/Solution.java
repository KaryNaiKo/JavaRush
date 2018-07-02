package com.javarush.task.task17.task1710;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        switch (args[0]) {
            case "-c":
                create(args[1], args[2], args[3]);
                break;
            case "-u":
                update(args[1], args[2], args[3], args[4]);
                break;
            case "-d":
                delete(args[1]);
                break;
            case "-i":
                info(args[1]);
                break;
        }
    }

    public static void create(String name, String sex, String bd){
        //System.out.println("name=" + name + " sex=" + sex + " bd=" + bd);
        if(sex.equals("м")) allPeople.add(Person.createMale(name, new Date(bd)));
        else allPeople.add(Person.createFemale(name, new Date(bd)));
        System.out.println(allPeople.size()-1);
    }

    public static void update(String id, String name, String sex, String bd) {
        if(sex.equals("м")) allPeople.set(Integer.parseInt(id), Person.createMale(name, new Date(bd)));
        else allPeople.set(Integer.parseInt(id), Person.createFemale(name, new Date(bd)));
    }

    public static void delete(String id) {
        //allPeople.remove(Integer.parseInt(id));
        allPeople.set(Integer.parseInt(id), null);
    }

    public static void info(String id) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMMM-yyyy", Locale.ENGLISH);
        System.out.println(String.format(allPeople.get(Integer.parseInt(id)).getName() + " "
                + allPeople.get(Integer.parseInt(id)).getSex() + " "
                + simpleDateFormat.format(allPeople.get(Integer.parseInt(id)).getBirthDay())));
    }
}
