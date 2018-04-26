package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null)
            throw new TooShortStringException();
        String[] str = string.split("\t");
        for (String s : str)
            System.out.println("+++"+s);
        if (str.length < 3)
            throw new TooShortStringException();
        return str[1];


    }

    public static class TooShortStringException extends Exception {


        public TooShortStringException() {
super();
        }
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
