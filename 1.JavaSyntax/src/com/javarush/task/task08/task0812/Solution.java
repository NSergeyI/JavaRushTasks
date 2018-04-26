package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }
        int max = 1;
        int count = 1;
        for (int i = 0; i < 9; i++) {
            if (list.get(i) == list.get(i + 1)) {
                ++count;
                if (max < count)
                    max = count;
            } else count = 1;
        }
        System.out.println(max);
        //напишите тут ваш код

    }
}