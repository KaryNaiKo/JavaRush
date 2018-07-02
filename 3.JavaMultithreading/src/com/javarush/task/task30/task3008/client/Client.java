package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Павлуша on 14.12.2017.
 */


public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Введите адрес сервера: ");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Введите порт сервера: ");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Введите имя коиента: ");
        return ConsoleHelper.readString();
    }


    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка отправки сообщения на сервер.");
            clientConnected = false;
        }
    }


    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        try {
            synchronized (this) {
                wait();
            }
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Произошла ошибка в методе run класса Client.");
        }

        if(clientConnected) ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        else ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");

        String str;
        while (clientConnected && !(str = ConsoleHelper.readString()).equals("exit") ) {
            if(shouldSendTextFromConsole()) sendTextMessage(str);
        }
    }

    public class SocketThread extends Thread {
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " присоединился к чату.");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " покинул чат.");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            synchronized (Client.this) {
                Client.this.clientConnected = clientConnected;
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (!clientConnected) {

                Message message = null;
                try {
                    message = connection.receive();
                } catch (Exception e) {
                    break;
                }

                if(message.getType() == MessageType.NAME_REQUEST) {
                    String str = getUserName();
                    connection.send(new Message(MessageType.USER_NAME, str));
                }
                else {
                    if(message.getType() == MessageType.NAME_ACCEPTED) {
                        notifyConnectionStatusChanged(true);
                    }
                    else throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = null;
                try {
                    message = connection.receive();
                } catch (Exception e) {
                    break;
                }

                if(message.getType() == MessageType.TEXT) {
                    processIncomingMessage(message.getData());
                }
                else {
                    if(message.getType() == MessageType.USER_ADDED) {
                        informAboutAddingNewUser(message.getData());
                    }
                    else {
                        if(message.getType() == MessageType.USER_REMOVED) {
                            informAboutDeletingNewUser(message.getData());
                        }
                        else break;
                    }
                }
            }
            throw new IOException("Unexpected MessageType");
        }

        @Override
        public void run() {
            String address = getServerAddress();
            int port = getServerPort();
            Socket socket;

            try {
                socket = new Socket(address, port);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }
    }
}
