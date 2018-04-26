package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sF = "";
        FileInputStream f = null;
        long l = 0;

        try {
            sF = reader.readLine();
            f = new FileInputStream(sF);
            byte[] masB = new byte[f.available()];
            f.read(masB);
            for (byte b : masB) {
                if (b == 44) l++;
            }
            reader.close();
            f.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(l);


    }
}
