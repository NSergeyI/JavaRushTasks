package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);
        boolean flag;
        flag = false;
        StringBuilder stringBuilder = new StringBuilder();
        String s;


        while (fileReader.ready()) {
            s = "";
            char c = (char) fileReader.read();
            while ((c != 32 && c != 10) && fileReader.ready()) {
                s = s + (char) c;
                c = (char) fileReader.read();
            }
            if (s.length() > 6) {
                stringBuilder.append(s).append(",");
                flag = true;
            }
        }
        if (flag) {
            fileWriter.write(stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString());
        }
        fileReader.close();
        fileWriter.close();

    }

}

