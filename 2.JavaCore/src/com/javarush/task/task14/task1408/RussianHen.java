package com.javarush.task.task14.task1408;



/**
 * Created by Павлуша on 18.07.2017.
 */
public class RussianHen extends Hen{

    @Override
    public int getCountOfEggsPerMonth() {
        return 10;
    }
    public String getDescription(){
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }

}