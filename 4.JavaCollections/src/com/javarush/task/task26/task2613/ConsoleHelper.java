package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Created by Павлуша on 03.05.2018.
 */
public class ConsoleHelper {
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        try {
            System.out.println(message);
        } catch (Exception e) {

        }
    }

    public static String readString() throws InterruptOperationException{
        try {
            String str = bis.readLine();
            if(str.toUpperCase().equals("EXIT")){
                writeMessage(res.getString("the.end"));
                throw new InterruptOperationException();
            }
            return str;
        } catch (IOException e) {

        }
        return null;
    }

    public static String askCurrencyCode() throws InterruptOperationException{
        writeMessage(res.getString("choose.currency.code"));
        String str = "";
        while (true) {
            str = readString();

            if(str.length() == 3) return str.toUpperCase();
            else {
                writeMessage(res.getString("invalid.data"));
            }
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException{
        String str = String.format(res.getString("choose.denomination.and.count.format"), currencyCode);
        writeMessage(str);
        while (true) {
            try {
                String entry = readString();
                boolean isValid = true;

                String denomination = entry.split(" ")[0];
                String countOfBanknotes = entry.split(" ")[1];

                char[] validation = denomination.toCharArray();
                for (int i = 0; i < validation.length; i++) {
                    if(!Character.isDigit(validation[i])) {
                        isValid = false;
                        break;
                    }
                }

                validation = countOfBanknotes.toCharArray();
                for (int i = 0; i < validation.length; i++) {
                    if(!Character.isDigit(validation[i])) {
                        isValid = false;
                        break;
                    }
                }

                if(isValid) {
                    return new String[] {denomination, countOfBanknotes};
                } else {
                    writeMessage(res.getString("invalid.data"));
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                writeMessage(res.getString("invalid.data"));
            }
        }
    }

    public static Operation askOperation() throws InterruptOperationException{
        writeMessage(res.getString("choose.operation"));
        writeMessage(res.getString("operation.INFO"));
        writeMessage(res.getString("operation.DEPOSIT"));
        writeMessage(res.getString("operation.WITHDRAW"));
        writeMessage(res.getString("operation.EXIT"));
        while (true) {
            try {
                int operation = Integer.parseInt(readString());
                return Operation.getAllowableOperationByOrdinal(operation);
            } catch (IllegalArgumentException e) {
                writeMessage("Incorrect operation.");
            }
        }
    }

    public static void printExitMessage() {
        writeMessage(res.getString("the.end"));
    }
}


/*
package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        try {
            System.out.println(message);
        } catch (Exception e) {

        }
    }

    public static String readString() throws InterruptOperationException{
        try {
            String str = bis.readLine();
            if(str.toUpperCase().equals("EXIT")) throw new InterruptOperationException();
            return str;
        } catch (IOException e) {

        }
        return null;
    }

    public static String askCurrencyCode() throws InterruptOperationException{
        writeMessage("Enter currency code:");
        String str = "";
        while (true) {
            str = readString();

            if(str.length() == 3) return str.toUpperCase();
            else {
                writeMessage("Incorrect currency code.");
            }
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException{
        writeMessage("Enter the denomination and the count of banknotes:");
        while (true) {
            try {
                String entry = readString();
                boolean isValid = true;

                String denomination = entry.split(" ")[0];
                String countOfBanknotes = entry.split(" ")[1];

                char[] validation = denomination.toCharArray();
                for (int i = 0; i < validation.length; i++) {
                    if(!Character.isDigit(validation[i])) {
                        isValid = false;
                        break;
                    }
                }

                validation = countOfBanknotes.toCharArray();
                for (int i = 0; i < validation.length; i++) {
                    if(!Character.isDigit(validation[i])) {
                        isValid = false;
                        break;
                    }
                }

                if(isValid) {
                    return new String[] {denomination, countOfBanknotes};
                } else {
                    writeMessage("Incorrect denomination or count of banknotes");
                }
            } catch (Exception e) {
                writeMessage("Incorrect denomination or count of banknotes");
            }
        }
    }

    public static Operation askOperation() {
        writeMessage("Choose operation:");
        writeMessage("1 - INFO");
        writeMessage("2 - DEPOSIT");
        writeMessage("3 - WITHDRAW");
        writeMessage("4 - EXIT");
        while (true) {
            try {
                int operation = Integer.parseInt(readString());
                return Operation.getAllowableOperationByOrdinal(operation);
            } catch (Exception e) {
                writeMessage("Incorrect operation.");
            }
        }
    }
}

 */