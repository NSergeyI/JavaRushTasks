package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 1, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        for (int y = 0; y < a.length; y++)
            for (int x = 0; x < a[y].length; x++)
                if ((a[y][x] == 1) && (x == 0 || a[y][x - 1] != 1) && (y == 0 || a[y - 1][x] != 1))
                    count++;

        return count;
    }


}


