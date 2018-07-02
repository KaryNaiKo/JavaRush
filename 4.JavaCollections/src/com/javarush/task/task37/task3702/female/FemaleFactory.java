package com.javarush.task.task37.task3702.female;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;


/**
 * Created by Павлуша on 11.04.2018.
 */
public class FemaleFactory implements AbstractFactory {
    @Override
    public Human getPerson(int age) {
        Human human = null;
        if(age > 0 & age <= KidGirl.MAX_AGE) human = new KidGirl();
        else if(age >  KidGirl.MAX_AGE & age <= TeenGirl.MAX_AGE) human = new TeenGirl();
        else if(age > TeenGirl.MAX_AGE) human = new Woman();

        return human;
    }
}
