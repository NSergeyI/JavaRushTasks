package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader readF = new BufferedReader(new InputStreamReader(System.in));
        String sF = readF.readLine();
        FileInputStream f = new FileInputStream(sF);
        int max = -1;
        int tek;
        while (f.available() > 0) {
            tek = f.read();
            if (max < tek) max = tek;
        }
        f.close();
        System.out.println(max);
    }
}
