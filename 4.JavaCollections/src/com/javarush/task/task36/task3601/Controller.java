package com.javarush.task.task36.task3601;

import java.util.List;

/**
 * Created by Павлуша on 11.04.2018.
 */
public class Controller {
    private Model model = new Model();

//    public Controller(Model model) {
//        this.model = model;
//
//    }

    public List<String> onDataListShow() {
        return model.getStringDataList();
    }


}
