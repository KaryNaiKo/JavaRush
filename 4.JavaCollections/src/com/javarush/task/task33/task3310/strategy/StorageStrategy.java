package com.javarush.task.task33.task3310.strategy;

/**
 * Created by Павлуша on 16.04.2018.
 */
public interface StorageStrategy {
    boolean containsKey(Long key);

    boolean containsValue(String value);

    void put(Long key, String value);

    Long getKey(String value);

    String getValue(Long key);
}
