package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {
    private FileInputStream stream;

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        if (fileName.subSequence(fileName.length()-4,fileName.length()).equals(".txt")){
            stream = new FileInputStream(fileName);
        }else {
            super.close();
            throw new UnsupportedFileNameException();
        }

    }

    public static void main(String[] args) {
    }
}

