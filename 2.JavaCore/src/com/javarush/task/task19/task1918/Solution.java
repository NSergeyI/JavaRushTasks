package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    private static String fileInput;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        fileName = reader.readLine();
//        fileName = "/home/winnie/JavaRush/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/1";
        reader.close();
        fileInput = "";
        FileReader fileReader = new FileReader(fileName);
        while (fileReader.ready()) {
            fileInput += (char) fileReader.read();
        }
        fileReader.close();
        fileInput = fileInput.replaceAll("\\n|\\r", "");
        String find, findZ;

        int start = 0, stop = 0, ch = 0;

        find = "<" + args[0];
        findZ = "</" + args[0] + ">";

        ArrayList<String> s = new ArrayList<>();
        while (start != -1 && stop != -1) {
            start = fileInput.indexOf(find, start);
            stop = fileInput.indexOf(findZ, start);

            ch = check(find, start, stop);
//            System.out.println(start + " : " + stop + " : " + ch);

            for (int i = 0; i < ch; i++) {
                stop = fileInput.indexOf(findZ, ++stop);
            }
            if (start != -1 && stop != -1) {
                s.add(fileInput.substring(start, stop + findZ.length()));
                start++;
            }
        }

        for (String sout : s)
            System.out.println(sout);

//        System.out.println(fileInput);
    }

    private static int check(String fine, int start, int stop) {
        int i = 0;
        while (start != -1) {
            start = fileInput.indexOf(fine, ++start);
//            System.out.println(start + " s:i " + i);
            if (start < stop && start != -1)
                i++;
        }
        return i;
    }

}
