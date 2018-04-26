package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileInputStream(reader.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (scanner.hasNextInt()) {
            int data = scanner.nextInt();
            if (data % 2 == 0) {
                arrayList.add(data);
            }
        }
        scanner.close();
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(arrayList);
        for (Integer arr : arrayList) {
            System.out.println(arr);
        }
        /* String fileName = "";
        InputStream file = null;
        BufferedReader readerF =null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        try {
            fileName = reader.readLine();
            reader.close();
            readerF = new BufferedReader(new FileReader(fileName));
            while (readerF.ready()) {
                list.add(Integer.parseInt(readerF.readLine()));
            }

        } catch (Exception e) {
        }
        try {
            readerF.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // check even & add list2
        for (Integer i : list){
            if (i%2 == 0) list2.add(i);
        }

        Collections.sort(list2,new Comparator<Integer>() {
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                }
        );
        for (Integer i : list2) System.out.println(i);
    }*/
    }
}
