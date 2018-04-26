package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1;
        fileName1 = reader.readLine();
        String fileName2;
        fileName2 = reader.readLine();
        reader.close();
//        fileName1 = "/home/winnie/JavaRush/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/1";
//        fileName2 = "/home/winnie/JavaRush/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/2";
        FileReader fileReader = new FileReader(fileName1);
        FileWriter fileWriter = new FileWriter(fileName2);
        Boolean even = false;
        int byteF;
        while (fileReader.ready()) {
            byteF = fileReader.read();
            if (even) {
                fileWriter.write(byteF);
                System.out.println(byteF);
                even = false;
            } else {
                even = true;
            }

        }
        fileReader.close();
        fileWriter.close();

    }
}
