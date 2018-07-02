package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Павлуша on 03.05.2018.
 * будет хранить всю информацию про выбранную валюту.
 */
public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();        // - это Map<номинал, количество>.

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if(denominations.containsKey(denomination)) {
            int oldCount = denominations.get(denomination);
            denominations.put(denomination, oldCount + count);
        } else {
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount() {
        int totalAmount = 0;

        for (Map.Entry<Integer, Integer> pair : denominations.entrySet()) {
            int denomination = pair.getKey();
            int countOfbanknotes = pair.getValue();
            totalAmount += denomination * countOfbanknotes;
        }

        return totalAmount;
    }

    public boolean hasMoney() {
        return getTotalAmount() > 0;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        HashMap<Integer, Integer> withdrawData = new HashMap<>();
        int iterableAmount = expectedAmount;

        while (iterableAmount > 0) {
            int[] maxBanknotes = getMaxBanknote(iterableAmount);
            int maxBanknoteDenomination = maxBanknotes[0];
            int countOfBanknotes = maxBanknotes[1];
            if(maxBanknoteDenomination < 0 || countOfBanknotes < 0) throw new NotEnoughMoneyException();

            if(maxBanknoteDenomination*countOfBanknotes > iterableAmount) {
                countOfBanknotes = iterableAmount / maxBanknoteDenomination;
            }

            iterableAmount -= maxBanknoteDenomination*countOfBanknotes;
            withdrawData.put(maxBanknoteDenomination, countOfBanknotes);
        }

        if(iterableAmount < 0) throw new NotEnoughMoneyException();

        reduceData(withdrawData);

        return withdrawData;
    }

    private void reduceData(HashMap<Integer, Integer> withdrawData) {
        for (Map.Entry<Integer, Integer> pair : withdrawData.entrySet()) {
            int denomination = pair.getKey();
            int count = pair.getValue();
            int countToReduce = denominations.get(denomination);

            denominations.put(denomination, countToReduce - count);
        }
    }

    private int[] getMaxBanknote(int remainderAmount) {
        int maxBanknoteDenomination = -1;
        int countOfBanknotes = -1;

        for (Map.Entry<Integer, Integer> pair : denominations.entrySet()) {
            int denomination = pair.getKey();
            int count = pair.getValue();
            if(denomination > maxBanknoteDenomination && count > 0 && denomination <= remainderAmount) {
                maxBanknoteDenomination = denomination;
                countOfBanknotes = count;
            }
        }

        return new int[] {maxBanknoteDenomination, countOfBanknotes};
    }

//    public static void main(String[] args) throws Exception{
//        CurrencyManipulator currencyManipulator = new CurrencyManipulator("USD");
//        currencyManipulator.addAmount(500, 2);
//        currencyManipulator.addAmount(200, 3);
//        currencyManipulator.addAmount(100, 1);
//        currencyManipulator.addAmount(50, 12);
//
//
//        System.out.println(currencyManipulator.denominations);
//        System.out.println(currencyManipulator.withdrawAmount(1));
//        System.out.println(currencyManipulator.denominations);
//    }
}
