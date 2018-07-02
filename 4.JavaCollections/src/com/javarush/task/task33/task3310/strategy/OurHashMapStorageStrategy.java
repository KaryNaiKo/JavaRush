package com.javarush.task.task33.task3310.strategy;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Created by Павлуша on 17.04.2018.
 */
public class OurHashMapStorageStrategy implements StorageStrategy {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    private int size;
    private int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    private float loadFactor = DEFAULT_LOAD_FACTOR;


    public int hash(Long k) {
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }

    public int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    public Entry getEntry(Long key) {
        for (int i = 0; i < table.length; i++) {
            if(table[i].getKey().equals(key)) return table[i];
        }
        return null;
    }

    public void resize(int newCapacity) {
        if (size > newCapacity)
        {
            return;
        }

        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int)(newCapacity * loadFactor);
    }

    public void transfer(Entry[] newTable) {
        Entry[] src = table;
        int newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++) {
            Entry e = src[j];
            if (e != null) {
                src[j] = null;
                do {
                    Entry next = e.next;
                    int i = indexFor(e.hash, newCapacity);
                    e.next = newTable[i];
                    newTable[i] = e;
                    e = next;
                } while (e != null);
            }
        }
    }

    public void addEntry(int hash, Long key, String value, int bucketIndex){
//        if (bucketIndex <= size) {
//            createEntry(hash, key, value, bucketIndex);
//            table[bucketIndex] = newEntry;
//        }

        Entry e = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, e);
        if (size++ >= threshold)
            resize(2 * table.length);
    }

    public void createEntry(int hash, Long key, String value, int bucketIndex) {
        //    Entry newEntry = new Entry(hash, key, value, null);


        Entry e = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, e);
        size++;
    }


    @Override
    public boolean containsKey(Long key) {
        for (int i = 0; i < table.length; i++) {
            if(table[i] != null) {
                if(table[i].getKey().equals(key)) return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(String value) {
        for (int i = 0; i < table.length; i++) {
            if(table[i] != null) {
                if(table[i].getValue().equals(value)) return true;
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash( new Long(key.hashCode()));
        int i = indexFor(hash, table.length);

        addEntry(hash, key, value, i);
    }

    @Override
    public Long getKey(String value) {
        for (int i = 0; i < table.length; i++) {
            if(table[i] != null) {
                if(table[i].getValue().equals(value)) return table[i].getKey();
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {

        for (int i = 0; i < table.length; i++) {
            if(table[i] != null) {
                if(table[i].getKey().equals(key)) return table[i].getValue();
            }
        }
        return null;
    }
}
