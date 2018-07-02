package com.javarush.task.task33.task3310;

import java.io.Serializable;

/**
 * Created by Павлуша on 22.04.2018.
 */
public class TestCube implements Serializable{
    private int volume;
    private int a;
    private int b;
    private int c;
    TestCube next;

    public TestCube(int a, int b, int c, TestCube cube) {
        this.a = a;
        this.b = b;
        this.c = c;
        volume  = a * b * c;
        next = cube;
    }

    public int getVolume() {
        volume = a*b*c;
        return volume;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TestCube{" +
                "volume=" + volume +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}');

        TestCube cube = next;
        while (cube != null) {
            sb.append("TestCube{" +
                    "volume=" + cube.getVolume() +
                    ", a=" + cube.getA() +
                    ", b=" + cube.getB() +
                    ", c=" + cube.getC() +
                    '}');
            cube = cube.next;
        }

        return sb.toString();
    }
}
