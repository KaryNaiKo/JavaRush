package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.StorageStrategy;

/**
 * Created by Павлуша on 16.04.2018.
 */
public class Shortener {
    private Long lastId = 0L;
    //хранится стратегия хранения данных.
    private StorageStrategy storageStrategy;

    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    //возвращает идентификатор id для заданной строки
    public synchronized Long getId(String string){
        if(storageStrategy.containsValue(string)) {
            return storageStrategy.getKey(string);
        } else {
            lastId++;
            storageStrategy.put(lastId, string);
            return lastId;
        }
    }

    //возвращает строку для заданного идентификатора или null, если передан неверный идентификатор.
    public synchronized String getString(Long id) {
        return storageStrategy.getValue(id);
    }
}
