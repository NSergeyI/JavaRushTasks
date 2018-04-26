package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));
//        boolean flag;

        while (fileReader.ready()) {
//            flag = false;
            StringBuilder stringBuilder = new StringBuilder();
            String[] words = fileReader.readLine().split(" ");
            for (String s : words) {
                byte[] bwords = s.getBytes();
                for (byte b : bwords)
                    if (b >= 48 && b <= 57) {
//                        flag = true;
                        fileWriter.write(s+" ");
                        break;
                    }
            }
//            if (flag) {
//                fileWriter.write(stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString());
//            }


        }
        fileReader.close();
        fileWriter.close();
    }
}
