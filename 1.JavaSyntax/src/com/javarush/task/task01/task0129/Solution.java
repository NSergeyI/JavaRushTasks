package com.javarush.task.task01.task0129;

/* 
Считаем длину окружности
*/

public class Solution {
    public static double Pi = 3.14;
    public static void main(String[] args) {
        printCircleLength(5);
    }

    public static void printCircleLength(int radius) {
        System.out.println((double) 2 * Pi * radius);
        //напишите тут ваш код
    }
}