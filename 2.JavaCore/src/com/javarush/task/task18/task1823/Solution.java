package com.javarush.task.task18.task1823;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        BufferedReader cons = new BufferedReader(new InputStreamReader(System.in));
        String stopWord = "exit";
        ArrayList<String> fm = new ArrayList<>();
        try {
            String sCons = cons.readLine();
            while (!sCons.equals(stopWord)) {
                fm.add(sCons);
                sCons = cons.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s :fm){
            ReadThread t = new ReadThread(s);
            t.start();

        }
    }

    public static class ReadThread extends Thread {
        private String fileN;

        public ReadThread(String fileName) {
            this.fileN = fileName;
            //implement constructor body
        }

        public void run() {
            try {
                FileInputStream f = new FileInputStream(fileN);
                HashMap<Byte, Integer> hm = new HashMap<>();
                byte b;
                while (f.available() > 0) {
                    b = (byte) f.read();
                    hm.put(b, hm.containsKey(b) ? hm.get(b) + 1: 1);
                }
                f.close();
                byte bMax = -1;
                int iMax = -1;
                for(Map.Entry<Byte,Integer> map:hm.entrySet()){
                    if (map.getValue()>iMax) {
                        bMax = map.getKey();
                        iMax = map.getValue();
                    }
                }
                resultMap.put(fileN,(int) bMax);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
