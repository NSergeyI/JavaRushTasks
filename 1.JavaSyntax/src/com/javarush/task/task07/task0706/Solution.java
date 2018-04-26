package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        int odd = 0;
        int even = 0;

        int[] dom = new int[15];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 15; i++) {
            dom[i] = Integer.parseInt(reader.readLine());
        }
        for (int i = 0; i < 15; i++) {
//            System.out.println(i/2);
            if (i % 2 == 0) {
                even += dom[i];
//                System.out.println("even: " + even);
            } else {
                odd += dom[i];
//                System.out.println("odd: " + odd);
            }
        }
        if (even > odd) {
            System.out.println("В домах с четными номерами проживает больше жителей.");
        } else {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }
        //напишите тут ваш код
    }
}
