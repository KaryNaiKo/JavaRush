package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.List;

/**
 * Created by Павлуша on 26.04.2018.
 * Отвечает за получение данных с сайта.
 */
public interface Strategy {
    List<Vacancy> getVacancies(String searchString);
}
