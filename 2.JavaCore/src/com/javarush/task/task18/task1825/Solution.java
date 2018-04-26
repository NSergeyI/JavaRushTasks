package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer,String> fileName = new TreeMap<>();
        String s;
        s = reader.readLine();
        String s2 =s;
        while (!s.equals("end")) {
            int n = Integer.parseInt(s.substring(s.lastIndexOf(".")+5)); //N part
            fileName.put(n,s);
            s=reader.readLine();
        }
        reader.close();
        String newFile = s2.substring(0,s2.lastIndexOf("."));
        File f = new File(newFile);
        f.createNewFile();
        BufferedWriter fW = new BufferedWriter(new FileWriter(newFile));

        for (Map.Entry<Integer,String> m :fileName.entrySet()) {
        BufferedReader fR = new BufferedReader(new FileReader(m.getValue()));
        while (fR.ready())
        fW.write(fR.readLine());
        fR.close();
        }
        fW.close();
    }
}
