package com.javarush.task.task27.task2712.ad;

/**
 * Created by Павлуша on 08.03.2018.
 * Object content - видео
 * String name - имя/название
 * long initialAmount - начальная сумма, стоимость рекламы в копейках. Используем long, чтобы избежать проблем с округлением
 * int hits - количество оплаченных показов
 * int duration - продолжительность в секундах
 * Модификаторы доступа расставь самостоятельно.
 */
public class Advertisement {
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;
    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        amountPerOneDisplaying = initialAmount / hits;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public void revalidate() {
        if(hits < 1) {
            throw new UnsupportedOperationException();
        } else {
            hits--;
        }
    }

    public int getHits() {
        return hits;
    }
}
