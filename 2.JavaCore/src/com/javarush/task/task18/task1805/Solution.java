package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/*
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileName = rd.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        while (fileInputStream.available() > 0) {
            int a = fileInputStream.read();
            map.put(a, map.containsKey(a) ? map.get(a) + 1 : 1);
        }

        int min = map.size();
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            list.add(pair.getKey());
        }
        Collections.sort(list);
        for (Integer i:list){
            System.out.print(i+" ");
        }
        /*for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() == min) {
                System.out.print(pair.getKey() + " ");
            }
        }*/

        System.out.println();
        rd.close();
        fileInputStream.close();
    }
}
