package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
       reset(); //add your code here - добавьте код тут
    }

    public static Flyable result;

    public static void reset() {
        //add your code here - добавьте код тут
        String s = "";
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        try{
            s = read.readLine();


            if (s.contains("helicopter")){
               result = new Helicopter();
            }else {
                s = read.readLine();
                result = new Plane(Integer.parseInt(s));
            }
            read.close();
        }catch (Exception ex){
        }

    }
}
