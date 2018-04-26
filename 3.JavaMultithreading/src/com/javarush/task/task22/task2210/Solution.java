package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        String[] strings = getTokens("level22.lesson13.task01", ".");
        for (String s : strings
                ) {
            System.out.println(s);
        }
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        String[] strings = new String[stringTokenizer.countTokens()];

        int count = stringTokenizer.countTokens();
        for (int i = 0; i <count; i++) {
            strings[i] = stringTokenizer.nextToken();

        }


        return strings;
    }
}
