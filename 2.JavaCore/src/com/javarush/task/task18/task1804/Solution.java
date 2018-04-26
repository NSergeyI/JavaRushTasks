package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileName  = rd.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        HashMap<Integer,Integer> map = new HashMap<>();


        while (fileInputStream.available()>0) {
            int a = fileInputStream.read();
            map.put(a,map.containsKey(a) ? map.get(a)+1 : 1);
        }

        int min = map.size();
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() < min) {
                min = pair.getValue();
            }
        }

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() == min) {
                System.out.print(pair.getKey()+" ");
            }
        }

        System.out.println();
        rd.close();
        fileInputStream.close();
    }
}
