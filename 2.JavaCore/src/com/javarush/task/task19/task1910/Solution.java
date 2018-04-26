package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1;
        String fileName2;
        fileName1 = reader.readLine();
        fileName2 = reader.readLine();
//        fileName1 = "/home/winnie/JavaRush/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/1";
//        fileName2 = "/home/winnie/JavaRush/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/2";
        reader.close();
        int inF;
        BufferedReader readerFile = new BufferedReader(new FileReader(fileName1));
        BufferedWriter writerFile = new BufferedWriter(new FileWriter(fileName2));
        while (readerFile.ready()) {
            inF =  readerFile.read();
            if ((inF == 32) || (inF >= 48 && inF <= 57) || (inF >= 65 && inF <= 90) || (inF >= 97 && inF <= 122) || (inF >= 192 && inF <= 255))
                writerFile.write(inF);
//            System.out.println(inF + " : " + (char) inF);
        }

        readerFile.close();
        writerFile.close();
    }
}