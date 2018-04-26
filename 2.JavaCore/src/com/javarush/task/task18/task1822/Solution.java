package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String sf = reader.readLine();
//            FileInputStream f = new FileInputStream(sf);
            BufferedReader rf = new BufferedReader(new FileReader(sf));
            String s;
          String id = args[0];
            while ((s=rf.readLine()) != null)
            {
                if (id.equals(s)) {
                    System.out.println(s);
//                    break;
                }
            }
            rf.close();
//            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
