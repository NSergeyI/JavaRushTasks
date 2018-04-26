package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s1 = reader.readLine();
            String s2 = reader.readLine();
//            s1 ="/home/winnie/JavaRush/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/1";
//            s2 = "/home/winnie/JavaRush/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/2";
            FileInputStream f1I = new FileInputStream(s1);
            int i = f1I.available();
            byte[] b1 = new byte[f1I.available()];
            f1I.read(b1);
            f1I.close();
            FileOutputStream f1O= new FileOutputStream(s1);
            FileInputStream f2 = new FileInputStream(s2);
            byte[] b2 = new byte[f2.available()];
            f2.read(b2);
            f1O.write(b2,0,b2.length);
            f1O.write(b1);
            f1O.close();
            f2.close();





        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
