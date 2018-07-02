package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
//import java.util.Calendar;
import java.util.Date;

/**
 * Created by Павлуша on 17.12.2017.
 */
public class BotClient extends Client {
    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int)(Math.random() * 100);
    }

    public class BotSocketThread extends Client.SocketThread {
        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (message != null && message.contains(":")) {
                String[] dataFromMessage = message.split(": ");
                String userName = dataFromMessage[0];
                String userText = dataFromMessage[1];

                String answerForUser = "Информация для " + userName + ": ";
                SimpleDateFormat simpleDateFormat;
                //Calendar calendar;
                Date date;

                switch (userText) {
                    case "дата" :
                        simpleDateFormat = new SimpleDateFormat("d.MM.YYYY");
                        answerForUser += simpleDateFormat.format(new Date().getTime());
                        sendTextMessage(answerForUser);
                        break;
                    case "день" :
                        simpleDateFormat = new SimpleDateFormat("d");
                        answerForUser += simpleDateFormat.format(new Date().getTime());
                        sendTextMessage(answerForUser);
                        break;
                    case "месяц" :
                        simpleDateFormat = new SimpleDateFormat("MMMM");
                        answerForUser += simpleDateFormat.format(new Date().getTime());
                        sendTextMessage(answerForUser);
                        break;
                    case "год" :
                        simpleDateFormat = new SimpleDateFormat("YYYY");
                        answerForUser += simpleDateFormat.format(new Date().getTime());
                        sendTextMessage(answerForUser);
                        break;
                    case "время" :
                        simpleDateFormat = new SimpleDateFormat("H:mm:ss");
                        answerForUser += simpleDateFormat.format(new Date().getTime());
                        sendTextMessage(answerForUser);
                        break;
                    case "час" :
                        simpleDateFormat = new SimpleDateFormat("H");
                        answerForUser += simpleDateFormat.format(new Date().getTime());
                        sendTextMessage(answerForUser);
                        break;
                    case "минуты" :
                        simpleDateFormat = new SimpleDateFormat("m");
                        answerForUser += simpleDateFormat.format(new Date().getTime());
                        sendTextMessage(answerForUser);
                        break;
                    case "секунды" :
                        simpleDateFormat = new SimpleDateFormat("s");
                        answerForUser += simpleDateFormat.format(new Date().getTime());
                        sendTextMessage(answerForUser);
                        break;
                }
            }
        }

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }
    }
}
