package com.javarush.task.task36.task3601;

import java.util.List;

/**
 * Created by Павлуша on 11.04.2018.
 */
public class Model {
    private Service service = new Service();

    public List<String> getStringDataList() {
        return service.getData();
    }

}
