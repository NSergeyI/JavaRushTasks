package com.javarush.task.task22.task2212;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
//        +380501234567 - true
//        + 38 (050) 1234567 - true
//        + 38050123 - 45 - 67 - true
//        050123 - 4567 - true
//        + 38)050 (1234567 - false
//        + 38 (050) 1 - 23 - 45 - 6 - 7 - false
//        050 ххх4567 - false
//        050123456 - false
//        (0) 501234567 - false
public class Solution {
    public static boolean checkTelNumber(String telNumber) {

        if (telNumber == null)
            return false;
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(telNumber);
        String string = "";
        while (m.find()) {
            string += m.group();
        }
        if ((Pattern.compile("^[+]").matcher(telNumber).find() && string.length() == 12) || (Pattern.compile("^[^+]").matcher(telNumber).find() && string.length() == 10)) {
            return Pattern.compile("^[+]?\\d+(\\(\\d{3}\\))?(\\d*[-]?\\d+){0,2}$").matcher(telNumber).find();
        } else return false;
    }

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("/home/winnie/JavaRush/JavaRushTasks/3.JavaMultithreading/src/com/javarush/task/task22/task2212/1");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String[] strings = bufferedReader.readLine().split(" ");
        bufferedReader.close();
        fileReader.close();
        for (String s : strings) {
            System.out.println(s + " - " + checkTelNumber(s));
        }

    }
}
