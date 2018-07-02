package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

/**
 * Created by Павлуша on 11.04.2018.
 */
public class MaleFactory implements AbstractFactory {
    @Override
    public Human getPerson(int age) {
        Human human = null;
        if(age > 0 & age <= KidBoy.MAX_AGE) human = new KidBoy();
        else if(age >  KidBoy.MAX_AGE & age <= TeenBoy.MAX_AGE) human = new TeenBoy();
        else if(age > TeenBoy.MAX_AGE) human = new Man();

        return human;
    }
}
