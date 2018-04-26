package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream f = new FileInputStream(args[0]);
            HashMap<Byte, Integer> hm = new HashMap<>();

            while (f.available() > 0) {
                byte i = (byte) f.read();
                hm.put(i, hm.containsKey(i) ? hm.get(i) + 1 : 1);
            }
            f.close();
            Map<Byte, Integer> tree = new TreeMap<>(hm);
            for (byte b : tree.keySet()) {
                System.out.println((char) b + " " + tree.get(b));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
