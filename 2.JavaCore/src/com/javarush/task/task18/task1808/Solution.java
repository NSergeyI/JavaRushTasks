package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sF1, sF2, sF3;
        int count;

        try {
            sF1 = reader.readLine();
            sF2 = reader.readLine();
            sF3 = reader.readLine();
//           sF2 = "/home/winnie/JavaRush/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1808/2";
//            sF1 = "/home/winnie/JavaRush/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1808/1";
//            sF3 = "/home/winnie/JavaRush/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1808/3";
            FileInputStream f1 = new FileInputStream(sF1);
            FileOutputStream f2 = new FileOutputStream(sF2);
            FileOutputStream f3 = new FileOutputStream(sF3);

            byte[] mb = new byte[f1.available()];
            f1.read(mb);
            f1.close();

            count = mb.length / 2;

            if (mb.length % 2 == 0) {
                f2.write(mb, 0, count);
                f3.write(mb, count, count);
            } else {
                f2.write(mb, 0, count+1);
                f3.write(mb, count + 1, count);
            }
            f2.close();
            f3.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
