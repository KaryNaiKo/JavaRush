package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

/**
 * Created by Павлуша on 06.05.2018.
 */
interface Command {
    void execute() throws InterruptOperationException;
}
