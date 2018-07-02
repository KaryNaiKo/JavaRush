package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.OurHashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Павлуша on 23.04.2018.
 */
public class SpeedTest {
    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        Date startTime = new Date();

        for (String str : strings) {
            ids.add(shortener.getId(str));
        }
        Date endTime = new Date();

        return endTime.getTime() - startTime.getTime();
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        Date startTime = new Date();

        for (Long id : ids) {
            strings.add(shortener.getString(id));
        }
        Date endTime = new Date();

        return endTime.getTime() - startTime.getTime();
    }

    @Test
    public void testHashMapStorage() {
        HashMapStorageStrategy storageStrategy = new HashMapStorageStrategy();
        Shortener shortener1 = new Shortener(storageStrategy);

        HashBiMapStorageStrategy ourStorageStrategy = new HashBiMapStorageStrategy();
        Shortener shortener2 = new Shortener(ourStorageStrategy);

        Set origStrings = new HashSet();
        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }

        Set idsForShortener1 = new HashSet();
        long timeForShortener1 = getTimeForGettingIds(shortener1, origStrings, idsForShortener1);

        Set idsForShortener2 = new HashSet();
        long timeForShortener2 = getTimeForGettingIds(shortener2, origStrings, idsForShortener2);

        Assert.assertTrue(timeForShortener1 > timeForShortener2);


        Set stringsForShortener1 = new HashSet();
        timeForShortener1 = getTimeForGettingStrings(shortener1, idsForShortener1, stringsForShortener1);

        Set stringsForShortener2 = new HashSet();
        timeForShortener2 = getTimeForGettingStrings(shortener2, idsForShortener2, stringsForShortener2);

        Assert.assertEquals(timeForShortener1, timeForShortener2, 30);
    }
}
