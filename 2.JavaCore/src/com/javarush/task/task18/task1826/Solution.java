package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {


    public static void main(String[] args) throws IOException {

        String fileName = args[1];
        String fileOutputName = args[2];
        FileInputStream fInput = new FileInputStream(fileName);
        FileOutputStream fOut = new FileOutputStream(fileOutputName);

        byte[] bInput = new byte[fInput.available()];
        fInput.read(bInput);
        fInput.close();

        switch (args[0]) {
            case "-e": {
                for (byte b : bInput)
                    fOut.write(b - 10);
                break;
            }
            case "-d": {
                for (byte b :bInput)
                    fOut.write(b+10);
                break;
            }
        }
        fOut.close();
    }

}
