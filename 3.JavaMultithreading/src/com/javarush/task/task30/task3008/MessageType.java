package com.javarush.task.task30.task3008;

/**
 * Created by Павлуша on 13.12.2017.
 */

//MessageType – enum, который отвечает за тип сообщений пересылаемых между клиентом и сервером.

public enum  MessageType {
    NAME_REQUEST,
    USER_NAME,
    NAME_ACCEPTED,
    TEXT,
    USER_ADDED,
    USER_REMOVED;
}
