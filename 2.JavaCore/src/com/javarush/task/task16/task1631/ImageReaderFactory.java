package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by Павлуша on 04.08.2017.
 */
public  class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes im) throws IllegalArgumentException{
        if(im == ImageTypes.BMP) return new BmpReader();
        else if(im == ImageTypes.JPG) return new JpgReader();
        else if(im == ImageTypes.PNG) return new PngReader();

        throw new IllegalArgumentException("Неизвестный тип картинки«");
        //return null;
    }
}
