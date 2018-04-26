package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        String input = "";
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
//        try{
        for (;;) {
            try {


                input = read.readLine();
                if (!input.contains("exit")) {
                    if (input.contains(".")) {
                        print(Double.parseDouble(input));
                    } else {
                        if (Integer.parseInt(input) > 0 && Integer.parseInt(input) < 128) {
                            print(Short.parseShort(input));
                        } else {
                            if ((Integer.parseInt(input) <= 0) || (Integer.parseInt(input) >= 128)) {
                                print(Integer.parseInt(input));
                            } else {
                                print(input);
                            }
                        }
                    }
                } else {
                    break;
                }



            }
            catch(Exception ex){
//                ex.printStackTrace();
                print(input);
                //напиште тут ваш код
            }
        }
        read.close();
    }


    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
