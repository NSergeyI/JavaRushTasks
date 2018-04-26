package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArrayOutputStream);
        System.setOut(stream);

        testString.printSomething();
        String result = byteArrayOutputStream.toString();
        System.setOut(console);
        char c = 10; //перевод строки
        String[] strings = result.split("" + c);
        int count = 0;
        for (String s : strings) {
            count++;
            if (count == 3) {
                System.out.println("JavaRush - курсы Java онлайн");
                count = 1;
            }
            System.out.println(s);
        }
//        System.out.println(result);
    }

    private static void streamOut(ByteArrayOutputStream by) {
        System.out.println(by.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
