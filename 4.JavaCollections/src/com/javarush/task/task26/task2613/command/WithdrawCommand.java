package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by Павлуша on 06.05.2018.
 */
class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH +"withdraw_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        while (true){
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            String sAmount = ConsoleHelper.readString();
            try {
                int amount = Integer.parseInt(sAmount);
                if (manipulator.isAmountAvailable(amount)){
                    Map<Integer,Integer> map = new TreeMap<>(Collections.reverseOrder());
                    map.putAll(manipulator.withdrawAmount(amount));
                    for (Map.Entry<Integer, Integer> entry: map.entrySet()){
                        ConsoleHelper.writeMessage(String.format("\t%d - %d", entry.getKey(),entry.getValue()));
                    }
                    String successString = String.format(res.getString("success.format"), sAmount, manipulator.getCurrencyCode());
                    ConsoleHelper.writeMessage(successString);
                    break;

                }
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
            }catch (NumberFormatException ignored){
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            }
        }
    }
}

/*
    @Override
    public void execute() throws InterruptOperationException{
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);

        if(!manipulator.hasMoney()) {
            ConsoleHelper.writeMessage("Until there is no money.");
            return;
        }

        while (true) {
            try {
                int amount = getAmount();

                if(manipulator.isAmountAvailable(amount)) {
                    Map<Integer,  Integer> data =  manipulator.withdrawAmount(amount);
                    printData(data);
                    ConsoleHelper.writeMessage("The transaction was successful.");
                    break;
                } else {
                    ConsoleHelper.writeMessage("Not enough money.");
                }
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage("NotEnoughMoneyException.");
            }
        }
    }

    private void printData(Map<Integer,  Integer> data) {
        TreeMap<Integer,  Integer> treeMap = new TreeMap<>(data);
        for (Map.Entry<Integer,  Integer> pair : treeMap.entrySet()) {
            ConsoleHelper.writeMessage("\t" + pair.getKey() + " - " + pair.getValue());
        }
    }

    private int getAmount() throws InterruptOperationException{
        while (true) {
            ConsoleHelper.writeMessage("Enter amount:");
            String amount = ConsoleHelper.readString();
            boolean isValid = true;

            char[] validation = amount.toCharArray();
            for (int i = 0; i < validation.length; i++) {
                if(!Character.isDigit(validation[i])) {
                    isValid = false;
                    break;
                }
            }

            if(isValid) {
                return Integer.parseInt(amount);
            } else {
                ConsoleHelper.writeMessage("Incorrect amount.");
            }
        }
    }
 */
