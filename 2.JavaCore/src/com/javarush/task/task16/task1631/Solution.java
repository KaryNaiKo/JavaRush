package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.ImageReader;
import com.javarush.task.task16.task1631.common.ImageTypes;

public class Solution {
    public static void main(String[] args) {
        try {
            ImageReader reader = ImageReaderFactory.getImageReader(ImageTypes.JPG);
            ImageReader reader1 = ImageReaderFactory.getImageReader(ImageTypes.ASD);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException(«Неизвестный тип картинки«)");
        }
    }
}
