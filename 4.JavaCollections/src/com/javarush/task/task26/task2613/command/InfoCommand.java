package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.ResourceBundle;

/**
 * Created by Павлуша on 06.05.2018.
 */
class InfoCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");

    @Override
    public void execute() {
        ConsoleHelper.writeMessage(res.getString("before"));
        Collection<CurrencyManipulator> manipulators = CurrencyManipulatorFactory.getAllCurrencyManipulators();

        if(manipulators.size() == 0) {
            ConsoleHelper.writeMessage(res.getString("no.money"));
            return;
        }


        for (CurrencyManipulator manipulator : manipulators) {
            if (manipulator.hasMoney()) {
                String currencyCode = manipulator.getCurrencyCode();
                int totalAmount = manipulator.getTotalAmount();
                ConsoleHelper.writeMessage(currencyCode + " - " + totalAmount);
            } else {
                ConsoleHelper.writeMessage(res.getString("no.money"));
            }
        }
    }
}
