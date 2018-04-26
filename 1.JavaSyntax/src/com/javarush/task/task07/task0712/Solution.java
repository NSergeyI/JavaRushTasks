package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> spisok = new ArrayList<String>();
        int max = 0;
        int min = 0;
        int imax = 0;
        int imin = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++){
            spisok.add(reader.readLine());
            if (spisok.get(max).length() < spisok.get(i).length()) max = i;
            if (spisok.get(min).length() > spisok.get(i).length()) min = i;
        }

        if (max<min) System.out.println(spisok.get(max));
        else System.out.println(spisok.get(min));
        //напишите тут ваш код
    }
}
