package com.javarush.task.task36.task3603;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Павлуша on 12.04.2018.
 */
public class ClassNameToBeReplaced<T>  extends CopyOnWriteArrayList<T> {

    public void methodNameToBeReplaced(List<T> collection) {
        for (int i = 0; i < collection.size(); i++) {
            addIfAbsent(collection.get(i));
        }
    }
}
