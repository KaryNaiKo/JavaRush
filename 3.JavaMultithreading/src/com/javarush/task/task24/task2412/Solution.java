package com.javarush.task.task24.task2412;

import java.text.ChoiceFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Знания - сила!
*/
public class Solution {
    public static void main(String[] args) {
        List<Stock> stocks = getStocks();
        sort(stocks);
        Date actualDate = new Date();
        printStocks(stocks, actualDate);
    }

    public static void printStocks(List<Stock> stocks, Date actualDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        double[] filelimits = {0d, actualDate.getTime()};
        String[] filepart = {"closed {4}", "open {2} and last {3}"};

        ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
        Format[] testFormats = {null, null, dateFormat, fileform};
        MessageFormat pattform = new MessageFormat("{0}   {1} | {5} {6}");
        pattform.setFormats(testFormats);

        for (Stock stock : stocks) {
            String name = ((String) stock.get("name"));
            String symbol = (String) stock.get("symbol");
            double open = !stock.containsKey("open") ? 0 : ((double) stock.get("open"));
            double last = !stock.containsKey("last") ? 0 : ((double) stock.get("last"));
            double change = !stock.containsKey("change") ? 0 : ((double) stock.get("change"));
            Date date = (Date) stock.get("date");
            Object[] testArgs = {name, symbol, open, last, change, date, date.getTime()};
            System.out.println(pattform.format(testArgs));
        }
    }

    public static void sort(List<Stock> list) {
        Collections.sort(list, new Comparator<Stock>() {
            public int compare(Stock stock1, Stock stock2) {
                String name1 = (String) stock1.get("name");
                String name2 = (String) stock2.get("name");

                if(name1.compareTo(name2) == 0) {
                    Date date1 = (Date) stock1.get("date");
                    Date date2 = (Date) stock2.get("date");

                    if(date1.getMonth() == date2.getMonth()) {

                        if(date1.getDay() == date2.getDay()) {

                            double db1 = (double) stock1.get("open") - (double) stock1.get("last");
                            double db2 = (double) stock2.get("open") - (double) stock2.get("last");
                            if(db1 == db2) return 0;
                            else {
                                if(db1 < db2) return -1;
                                else return 1;
                            }

                        } else {
                            if(date1.getDay() < date2.getDay()) {
                                return -1;
                            } else {
                                return 1;
                            }
                        }
                    } else {
                        if(date1.getMonth() < date2.getMonth()) {
                            return -1;
                        } else {
                            return 1;
                        }
                    }

                } else {
                    if(name1.compareTo(name2) < 0) {
                        return -1;
                    } else {
                        return 1;
                    }
                }

                //return 0;
            }
        });
    }

    public static class Stock extends HashMap {
        public Stock(String name, String symbol, double open, double last) {
            put("name", name);
            put("symbol", symbol);
            put("open", open);
            put("last", last);
            put("date", getRandomDate(2020));
        }

        public Stock(String name, String symbol, double change, Date date) {
            put("name", name);
            put("symbol", symbol);
            put("date", date);
            put("change", change);
        }
    }

    public static List<Stock> getStocks() {
        List<Stock> stocks = new ArrayList();

        stocks.add(new Stock("Fake Apple Inc.", "AAPL", 125.64, 123.43));
        stocks.add(new Stock("Fake Cisco Systems, Inc.", "CSCO", 25.84, 26.3));
        stocks.add(new Stock("Fake Google Inc.", "GOOG", 516.2, 512.6));
        stocks.add(new Stock("Fake Intel Corporation", "INTC", 21.36, 21.53));
        stocks.add(new Stock("Fake Level 3 Communications, Inc.", "LVLT", 5.55, 5.54));
        stocks.add(new Stock("Fake Microsoft Corporation", "MSFT", 29.56, 29.72));

        stocks.add(new Stock("Fake Nokia Corporation (ADR)", "NOK", .1, getRandomDate()));
        stocks.add(new Stock("Fake Oracle Corporation", "ORCL", .15, getRandomDate()));
        stocks.add(new Stock("Fake Starbucks Corporation", "SBUX", .03, getRandomDate()));
        stocks.add(new Stock("Fake Yahoo! Inc.", "YHOO", .32, getRandomDate()));
        stocks.add(new Stock("Fake Applied Materials, Inc.", "AMAT", .26, getRandomDate()));
        stocks.add(new Stock("Fake Comcast Corporation", "CMCSA", .5, getRandomDate()));
        stocks.add(new Stock("Fake Sirius Satellite", "SIRI", -.03, getRandomDate()));

        return stocks;
    }

    public static Date getRandomDate() {
        return getRandomDate(1970);
    }

    public static Date getRandomDate(int startYear) {
        int year = startYear + (int) (Math.random() * 30);
        int month = (int) (Math.random() * 12);
        int day = (int) (Math.random() * 28);
        GregorianCalendar calendar = new GregorianCalendar(year, month, day);
        return calendar.getTime();
    }
}

/*
        Fake Apple Inc.   AAPL | 14-06-2040 open 125,64 and last 123,43
        Fake Cisco Systems, Inc.   CSCO | 19-05-2020 open 25,84 and last 26,3
        Fake Google Inc.   GOOG | 12-07-2044 open 516,2 and last 512,6
        Fake Intel Corporation   INTC | 21-05-2043 open 21,36 and last 21,53
        Fake Level 3 Communications, Inc.   LVLT | 28-02-2023 open 5,55 and last 5,54
        Fake Microsoft Corporation   MSFT | 17-08-2045 open 29,56 and last 29,72
        Fake Nokia Corporation (ADR)   NOK | 20-03-1989 closed 0,1
        Fake Oracle Corporation   ORCL | 15-08-1996 closed 0,15
        Fake Starbucks Corporation   SBUX | 07-03-1983 closed 0,03
        Fake Yahoo! Inc.   YHOO | 06-07-1980 closed 0,32
        Fake Applied Materials, Inc.   AMAT | 26-04-1996 closed 0,26
        Fake Comcast Corporation   CMCSA | 16-02-1987 closed 0,5
        Fake Sirius Satellite   SIRI | 21-06-1985 closed -0,03*/
