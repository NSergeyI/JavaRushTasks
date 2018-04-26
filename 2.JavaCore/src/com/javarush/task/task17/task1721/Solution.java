package com.javarush.task.task17.task1721;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = "";
        String s2 = "";
        try {
            s1 = reader.readLine();
            s2 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader f1 = null;
        BufferedReader f2 = null;
        try {
            f1 = new BufferedReader(new FileReader(s1));
            f2 = new BufferedReader(new FileReader(s2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            while (f1.ready())
                allLines.add(f1.readLine());
            while (f2.ready())
                forRemoveLines.add(f2.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Solution sol = new Solution();
        try {
            sol.joinData();

        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        for (String s : forRemoveLines) {
            if (allLines.contains(s)) {
                allLines.remove(allLines.indexOf(s));
            } else {
                allLines.clear();
                throw new CorruptedDataException();
            }
        }


    }
}
