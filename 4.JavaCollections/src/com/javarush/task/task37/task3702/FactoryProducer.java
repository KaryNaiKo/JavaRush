package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.female.FemaleFactory;
import com.javarush.task.task37.task3702.male.MaleFactory;

/**
 * Created by Павлуша on 11.04.2018.
 */
public class FactoryProducer {
    public static enum HumanFactoryType{
        MALE,
        FEMALE;
    }

    public static AbstractFactory getFactory(HumanFactoryType type) {
        if (type == HumanFactoryType.FEMALE) return new FemaleFactory();
        if (type == HumanFactoryType.MALE) return new MaleFactory();
        return null;
    }
}
