package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {


        BigInteger ret = BigInteger.valueOf(1);
        String s;
        if (n > 0) {
            for (int i = 1; i <= n; i++) ret = ret.multiply(BigInteger.valueOf(i));
            s = String.valueOf(ret);
        }
        else {
            if (n == 0) {
                s = "1";
            } else {
                s = "0";
            } //add your code here
        }
        return s;
    }
}
