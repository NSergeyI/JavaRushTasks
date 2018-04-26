package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream f = new FileInputStream(args[0]);
            byte[] b = new byte[f.available()];
            long count = 0;
            f.read(b);
            f.close();
            for (byte by : b) {
                if (((by >= 65) && (by <= 90)) || ((by >= 97) && (by <= 125))) count++;
            }

            System.out.println(count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
