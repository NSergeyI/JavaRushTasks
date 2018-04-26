package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consol = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArrayOutputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = byteArrayOutputStream.toString();
        String[] resultM = result.split(" ");
        int a = Integer.parseInt(resultM[0]);
        int b = Integer.parseInt(resultM[2]);
        String oper = resultM[1];
        int c;
        if (oper.equals("+"))
            c = a + b;
        else if (oper.equals("-"))
            c = a - b;
        else c = a * b;
        System.setOut(consol);
        System.out.println(result.toString().replaceAll("\\p{Cntrl}", "") + c);

//        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

