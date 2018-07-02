package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Павлуша on 16.04.2018.
 */
public class Solution {
    public static void main(String[] args) {
        Solution.testStrategy(new HashMapStorageStrategy(), 1000);
        Solution.testStrategy(new OurHashMapStorageStrategy(), 1000);
        Solution.testStrategy(new FileStorageStrategy(), 1000);
        Solution.testStrategy(new OurHashBiMapStorageStrategy(), 1000);
        Solution.testStrategy(new HashBiMapStorageStrategy(), 1000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        HashSet<Long> set = new HashSet<>();

        for (String str : strings) {
            set.add(shortener.getId(str));
        }

        return set;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        HashSet<String> set = new HashSet<>();

        for (Long l : keys) {
            set.add(shortener.getString(l));
        }

        return set;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());

        HashSet<String> list = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            list.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);

        Date startTime = new Date();
        Set ids = Solution.getIds(shortener, list);
        Date endTime = new Date();
        System.out.println(endTime.getTime() - startTime.getTime());

        startTime = new Date();
        Set strings = Solution.getStrings(shortener, ids);
        endTime = new Date();
        System.out.println(endTime.getTime() - startTime.getTime());

        System.out.println(list.size());
        System.out.println(strings.size());

        if(strings.equals(list)) {
            System.out.println("Тест пройден.");
        } else {
            System.out.println("Тест не пройден.");
        }
    }
}
