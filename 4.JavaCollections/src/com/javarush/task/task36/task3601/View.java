package com.javarush.task.task36.task3601;

import java.util.List;

/**
 * Created by Павлуша on 11.04.2018.
 */
public class View {
    private Controller controller = new Controller();

//    public view(Controller controller) {
//        this.controller = controller;
//    }

    public void fireEventShowData() {
        System.out.println(controller.onDataListShow());
    }
}
