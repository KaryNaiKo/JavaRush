package com.javarush.task.task26.task2613;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Павлуша on 03.05.2018.
 */
public class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> map = new HashMap<>();

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        currencyCode = currencyCode.toUpperCase();

        CurrencyManipulator currencyManipulator = map.get(currencyCode);

        if(currencyManipulator != null) return currencyManipulator;

        map.put(currencyCode, new CurrencyManipulator(currencyCode));

        return map.get(currencyCode);
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return map.values();
    }
}
