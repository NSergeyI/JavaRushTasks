package com.javarush.task.task15.task1515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Статики-2
*/

public class Solution {
    public static int A;
    public static int B;

    static
    {
        try {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            String sa = read.readLine();
            String sb = read.readLine();
            read.close();
            A = Integer.parseInt(sa);
            B = Integer.parseInt(sb);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static final int MIN = min(A, B);

    public static void main(String[] args) {
        System.out.println(MIN);
    }


    public static int min(int a, int b) {
        return a < b ? a : b;
    }
}
