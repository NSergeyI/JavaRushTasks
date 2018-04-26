package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            String s1, s2;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            s1 = reader.readLine();
            s2 = reader.readLine();
//            s1 = "/home/winnie/JavaRush/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1809/1";
//            s2 = "/home/winnie/JavaRush/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1809/2";

            FileInputStream f1 = new FileInputStream(s1);
            FileOutputStream f2 = new FileOutputStream(s2);
            byte[] b = new byte[f1.available()];
            f1.read(b);
            f1.close();
            for (int i = b.length - 1; i >= 0; i--) {
                f2.write(b[i]);
            }
            f2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
