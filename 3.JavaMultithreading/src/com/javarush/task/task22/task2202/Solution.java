package com.javarush.task.task22.task2202;

import javax.swing.plaf.synth.SynthOptionPaneUI;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null)
            throw new TooShortStringException();

        String result = "";

        int ind = -1;
        for (int i = 0; i < 5; i++) {
            ind = string.indexOf(" ", ++ind);
            if (ind == -1 && i < 4) {
                throw new TooShortStringException();
            } else if (ind == -1 && i == 4) {
                return string.substring(string.indexOf(" ") + 1);
            }

        }
        result = string.substring(string.indexOf(" ") + 1, ind);

        return result;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
