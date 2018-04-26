package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        while (fileReader.ready()) {
            String s1 = fileReader.readLine();
            String s2 = "";
            for (int i = s1.length() - 1; i >= 0; i--)
                s2 = s2 + s1.charAt(i);
            System.out.println(s2);
        }
        fileReader.close();
    }
}
