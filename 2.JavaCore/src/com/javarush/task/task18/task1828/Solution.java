package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader fileReadBuffer = new BufferedReader(new FileReader(fileName));
        ArrayList<String> frA = new ArrayList<>();
        String id = args[1];
        BigInteger idArgs = new BigInteger(id);
        String readFile;
        id = idArgs.toString();
        if (id.length() < 8)
            while (id.length() != 8)
                id = id + " ";
        else id = id.substring(0, 8);

        if (args[0].equals("-u")) {
            String productName = args[2];                                  //30
            String price = args[3];                                        //8
            String quantity = args[4];                                     //4
            String out;
            BigInteger idReadFile;

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

            out = id + productName + price + quantity + "\n";

            while (fileReadBuffer.ready()) {
                readFile = fileReadBuffer.readLine();
                if (id.equals(readFile.substring(0, 8)))
                    frA.add(out);
                else
                    frA.add(readFile + "\n");

            }
        }
        if (args[0].equals("-d")) {
            while (fileReadBuffer.ready()) {
                readFile = fileReadBuffer.readLine();
                if (!id.equals(readFile.substring(0, 8)))
                    frA.add(readFile + "\n");
            }
        }
        fileReadBuffer.close();
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
        for (String s : frA)
            fileWriter.write(s);
        fileWriter.close();
    }
}
