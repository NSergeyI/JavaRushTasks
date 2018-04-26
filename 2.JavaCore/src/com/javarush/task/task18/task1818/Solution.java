package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s1,s2,s3;
            s1 = reader.readLine();
            s2 = reader.readLine();
            s3 = reader.readLine();
            FileOutputStream f1 = new FileOutputStream(s1);
            FileInputStream f2 = new FileInputStream(s2);
            FileInputStream f3 = new FileInputStream(s3);
            byte[] by2 = new byte[f2.available()];
            byte[] by3 = new byte[f3.available()];
            f2.read(by2);
            f2.close();
            f3.read(by3);
            f3.close();
            f1.write(by2);
            f1.write(by3);
            f1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
