package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

//        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> hm = new TreeMap<>();
        String strIn;
        String strName;
        Double douName;
        while (bufferedReader.ready()) {
            strIn = bufferedReader.readLine();
            strName = strIn.substring(0, strIn.lastIndexOf(" "));
            douName = Double.parseDouble(strIn.substring(strIn.lastIndexOf(" ")));
            Double check = hm.put(strName, douName);
            if (!(check == null)) {
                hm.put(strName, check + douName);
            }
        }
        bufferedReader.close();
        Double max = 0.0;
        for (Map.Entry<String, Double> tree : hm.entrySet()) {
            if (max < tree.getValue()) max = tree.getValue();
//            System.out.println(tree.getKey()+" "+tree.getValue());

        }

        for (Map.Entry<String, Double> tree : hm.entrySet()) {
            if (max.equals(tree.getValue()))
            System.out.println(tree.getKey());
        }
    }
}
