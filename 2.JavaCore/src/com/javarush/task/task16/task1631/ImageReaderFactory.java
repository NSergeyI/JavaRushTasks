package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by winnie on 29.06.17.
 */
public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageTypes) {
        ImageReader result;
        if (imageTypes == ImageTypes.BMP) {
            result = new BmpReader();
        } else {
            if (imageTypes == ImageTypes.JPG) {
                result = new JpgReader();
            } else {
                if (imageTypes == ImageTypes.PNG) {
                    result = new PngReader();
                } else {
                    throw new IllegalArgumentException("Неизвестный тип картинки");
                }
            }
        }
        return result;
    }
}
