package com.javarush.task.task14.task1408;

/**
 * Created by Павлуша on 18.07.2017.
 */
public class BelarusianHen extends Hen{

    @Override
    public int getCountOfEggsPerMonth() {
        return 20;
    }

    public String getDescription(){
        return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
