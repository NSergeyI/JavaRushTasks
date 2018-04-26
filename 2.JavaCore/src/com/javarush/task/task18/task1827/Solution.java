package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.math.BigInteger;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        String productName = args[1];                                  //30
        String price = args[2];                                        //8
        String quantity = args[3];                                     //4
        String id, out;
        BigInteger idMax = new BigInteger("0");
        BigInteger idReadFile;
        String readFile;
        if (productName.length() < 30)
            while (productName.length() != 30)
                productName = productName + " ";
        else productName = productName.substring(0, 30);

        if (price.length() < 8)
            while (price.length() != 8)
                price = price + " ";
        else price = price.substring(0, 8);

        if (quantity.length() < 4)
            while (quantity.length() != 4)
                quantity = quantity + " ";
        else quantity = quantity.substring(0, 4);

        if (args[0].equals("-c")) {
            BufferedReader fileReadBuffer = new BufferedReader(new FileReader(fileName));
            ArrayList<String> frA = new ArrayList<>();
            while (fileReadBuffer.ready()) {
                readFile = fileReadBuffer.readLine();
                frA.add(readFile+"\n");
                readFile = readFile.substring(0, 8);
                if (readFile.indexOf(" ") != -1)
                    readFile = readFile.substring(0, readFile.indexOf(" "));
                idReadFile = new BigInteger(readFile);
                if (-1 == (idMax.compareTo(idReadFile))) {
                    idMax = idReadFile;
                }

            }
            fileReadBuffer.close();
            idMax = idMax.add(BigInteger.ONE);
            id = idMax.toString();
            if (id.length() < 8)
                while (id.length() != 8)
                    id = id + " ";
            else id = id.substring(0, 8);
            out = id + productName + price + quantity;
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
            for (String s : frA)
                fileWriter.write(s);
            fileWriter.write(out);
            fileWriter.close();
        }
    }
}
