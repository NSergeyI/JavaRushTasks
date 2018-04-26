package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream f = new FileInputStream(args[0]);
            byte[] bm = new byte[f.available()];
            int all = f.available();
            f.read(bm);
            f.close();
            int spc = 0;
            for (byte b : bm) {
                if (b == 32) spc++;
            }
            double d = (double) spc / all * 100;

            System.out.printf("%.2f",d);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
