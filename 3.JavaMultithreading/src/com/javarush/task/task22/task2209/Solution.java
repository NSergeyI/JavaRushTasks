package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {
        //...
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName;
        try {
            Scanner sc = new Scanner(System.in);
            //String file = "file.txt";
            String file = sc.nextLine();
            sc.close();
            sc = new Scanner(new File(file));
            ArrayList<String> wordslist = new ArrayList<>();
            while (sc.hasNext()) {
                wordslist.add(sc.next());
            }
            String[] words = new String[wordslist.size()];
            StringBuilder result = getLine(wordslist.toArray(words));
            System.out.println(result.toString());
//            fileName = reader.readLine();
//            reader.close();
////        fileName = "/home/winnie/JavaRush/JavaRushTasks/3.JavaMultithreading/src/com/javarush/task/task22/task2209/1";
//            String[] getFile = new String[0];
//            getFile = new BufferedReader(new FileReader(fileName)).readLine().split(" ");
//            StringBuilder result = getLine(getFile);
//            System.out.println(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static StringBuilder getLine(String... words) {
        if (!(words.length > 0) || words == null) return new StringBuilder();

        StringBuilder result = new StringBuilder(words[0]);
        char first = Character.toLowerCase(result.charAt(0));
        char last = Character.toUpperCase(result.charAt(result.length() - 1));
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 1; i < words.length; i++) {
                if (words[i] != null && last == words[i].charAt(0)) {
                    flag = true;
                    result.append(" ").append(words[i]);
                    last = Character.toUpperCase(result.charAt(result.length() - 1));
                    words[i] = null;
                } else {
                    if (words[i] != null && first == words[i].charAt(words[i].length() - 1)) {
                        flag = true;
                        result.insert(0, words[i] + " ");
                        first = Character.toUpperCase(words[i].charAt(words[i].length() - 1));
                        words[i] = null;
                    }
                }
            }
        }
        return result;
    }
}
