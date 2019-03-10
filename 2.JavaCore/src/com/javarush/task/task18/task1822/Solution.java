package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = null;
        BufferedReader fileBufReader = null;
        try {
            fileReader = new FileReader(reader.readLine());

            fileBufReader = new BufferedReader(fileReader);

            int id = Integer.parseInt(args[0]);

            while (fileBufReader.ready()) {
                String curentLine = fileBufReader.readLine();
                String curentIdString = curentLine.split(" ")[0];
                int curentId = Integer.parseInt(curentIdString);
                if (id == curentId) {
                    System.out.println(curentLine);
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                fileBufReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
