package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        fileName = reader.readLine();
//        fileName = "/home/winnie/JavaRush/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/1";
        reader.close();
        int count = 0;

        FileReader fileReader = new FileReader(fileName);
        while (fileReader.ready()) {
            String word = "";
            char c = (char) fileReader.read();
            while (fileReader.ready() && !(((c >= 32) && (c <= 47)) || (c == 10) || ((c >= 58) && (c <= 63)))) {
                word = word + c;
                c = (char) fileReader.read();
            }
            if ("world".equals(word))
                count++;
        }
        fileReader.close();
        System.out.println(count);
    }
}
