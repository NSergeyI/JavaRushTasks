package com.javarush.task.task06.task0606;

import java.io.*;
import java.util.ArrayList;

/*
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        String sIn, s;
        even = 0;
        odd = 0;
        ArrayList<Integer> aInt = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        sIn = reader.readLine();
        for (int i = 0; i < sIn.length();i++){
            s ="";
            aInt.add(Integer.parseInt(s+sIn.charAt(i)));
        }
        for (int i:aInt){

            if (i%2 == 0){
                even++;
            } else {
                odd++;
            }
        }
        System.out.println("Even: " + even + " Odd: " + odd);
        //напишите тут ваш код
    }
}
