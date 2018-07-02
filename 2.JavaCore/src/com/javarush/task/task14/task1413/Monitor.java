package com.javarush.task.task14.task1413;

import com.javarush.task.task14.task1413.CompItem;

/**
 * Created by Павлуша on 21.07.2017.
 */
public class Monitor implements CompItem {
    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
