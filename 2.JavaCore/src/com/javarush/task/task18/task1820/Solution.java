package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s1 = reader.readLine();
            String s2 = reader.readLine();
//            s1 = "/home/winnie/JavaRush/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/1";
//            s2 = "/home/winnie/JavaRush/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/2";
            FileInputStream f1 = new FileInputStream(s1);
            FileOutputStream f2 = new FileOutputStream(s2);
            BufferedReader bf1 = new BufferedReader(new InputStreamReader(f1));
            String s = bf1.readLine();
            String[] sm = s.split(" ");
            int[] im = new int[sm.length];
            s = ""+(int) Math.round(Double.parseDouble(sm[0]));
            f2.write(s.getBytes());
            for (int i = 1; i < sm.length; i++) {
                im[i] = (int) Math.round(Double.parseDouble(sm[i]));
                s = " " + im[i];
                f2.write(s.getBytes());
            }
            f1.close();
            f2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
