package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String snumber;
        Integer number = 0;
        int count = 0;
//        double eq;
        ArrayList<Integer> anumber = new ArrayList<Integer>();
        do{
            try {
                snumber = read.readLine();
                number = Integer.parseInt(snumber);
                anumber.add(number);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } while(number != -1);
        for (int i = 0; i < (anumber.size()-1); i++) {
            count = count + anumber.get(i);
//            System.out.println(anumber.get(i));
//            System.out.println(count);
//            System.out.println(" ");

        }
//        eq = count/(anumber.size()-1);
//        System.out.println(count);
//        System.out.println(anumber.size());
        System.out.println((double)count/(anumber.size()-1));
    }
}

