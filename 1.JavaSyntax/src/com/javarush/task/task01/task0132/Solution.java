package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {

        int s = number / 100;
        int d = (number - s *100) / 10;
        int e = number % 10;

        return s + d + e;
        //напишите тут ваш код
    }
}