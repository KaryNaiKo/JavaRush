package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Павлуша on 26.03.2018.
 */
@XmlRootElement
public class Shop {
    public Goods goods;
    public int count;
    public double profit;
    public String[] secretData;


    private static class Goods {
        List<String> names;
    }
}
