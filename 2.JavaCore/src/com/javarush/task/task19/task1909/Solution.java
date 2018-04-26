package com.javarush.task.task19.task1909;

/* 
Замена знаков
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
        String outF;
        String inF;
        BufferedReader readerFile = new BufferedReader(new FileReader(fileName1));
        BufferedWriter writerFile = new BufferedWriter(new FileWriter(fileName2));
        while (readerFile.ready()) {
            inF = readerFile.readLine();
            outF = inF.replace(".", "!") + "\n";
            writerFile.write(outF);
        }

        readerFile.close();
        writerFile.close();
    }
}
