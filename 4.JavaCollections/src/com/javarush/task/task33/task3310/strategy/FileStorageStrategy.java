package com.javarush.task.task33.task3310.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Павлуша on 19.04.2018.
 */


public class FileStorageStrategy implements StorageStrategy {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000;
    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    private int size;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    private long maxBucketSize = DEFAULT_INITIAL_CAPACITY;


    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    public int hash(Long k) {
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }

    public int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    public FileBucket getFileBucket(Long key) {
        for (int i = 0; i < table.length; i++) {
            if(table[i] != null) {
                Entry entry = table[i].getEntry();

                while (entry != null) {
                    if (entry.getKey().equals(key)) return table[i];
                    entry = entry.next;
                }
            }
        }
        return null;
    }

    public void resize(int newCapacity) {
        if (size > newCapacity)
        {
            return;
        }

        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                table[i].remove();
            }
        }
        table = newTable;
        maxBucketSize = maxBucketSize*2;
    }

    public void transfer(FileBucket[] newTable) {
        FileBucket[] src = table;
        int newCapacity = newTable.length;


        for (int j = 0; j < src.length; j++) {
            if(src[j] != null) {
                Entry entry = src[j].getEntry();

                while (entry != null) {
                    int index = indexFor(entry.hash, newCapacity);
                    addFileBucket(entry.hash, entry.getKey(), entry.getValue(), index);
                    entry = entry.next;
                }
            }
        }

    }

    public void addFileBucket(int hash, Long key, String value, int bucketIndex){

        if(table[bucketIndex] == null) {
            table[bucketIndex] = new FileBucket();
            table[bucketIndex].putEntry(new Entry(hash,key, value, null));
            size++;
        } else {
            Entry entry = table[bucketIndex].getEntry();
            table[bucketIndex].putEntry(new Entry(hash,key, value, entry));
            size++;
        }


        if(table[bucketIndex].getFileSize() > getBucketSizeLimit()) {
            resize((int)maxBucketSize * 2);
        }
    }

    public void createFileBucket(int hash, Long key, String value, int bucketIndex) {

    }

    @Override
    public boolean containsKey(Long key) {
        for (int i = 0; i < table.length; i++) {
            if(table[i] != null) {
                Entry entry = table[i].getEntry();

                while (entry != null) {
                    if (entry.getKey().equals(key)) return true;
                    entry = entry.next;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(String value) {
        for (int i = 0; i < table.length; i++) {
            if(table[i] != null) {
                Entry entry = table[i].getEntry();

                while (entry != null) {
                    if (entry.getValue().equals(value)) return true;
                    entry = entry.next;
                }
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(new Long(key.hashCode()));
        int i = indexFor(hash, table.length);

        addFileBucket(hash, key, value, i);
    }

    @Override
    public Long getKey(String value) {
        for (int i = 0; i < table.length; i++) {
            if(table[i] != null) {
                Entry entry = table[i].getEntry();

                while (entry != null) {
                    if (entry.getValue().equals(value)) return entry.getKey();
                    entry = entry.next;
                }
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        for (int i = 0; i < table.length; i++) {
            if(table[i] != null) {
                Entry entry = table[i].getEntry();

                while (entry != null) {
                    if (entry.getKey().equals(key)) return entry.getValue();
                    entry = entry.next;
                }
            }
        }
        return null;
    }
}
