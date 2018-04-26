package com.javarush.task.task20.task2025;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.text.SimpleDateFormat;
import java.util.*;

/*
Алгоритмы-числа
*/
public class Solution {

    public static int[] getNumbers(int N) {
        int[] result = null;
        List<Integer> list = new ArrayList<>();
        for (int n = 1; n < N; n++) {
            int sum = 0, temp, r;
            int q = 0;
            temp = n;
            int length = (int) (Math.log10(n) + 1);
            while (temp != 0) {
                for (int i = 0; i < length; i++) {
                    int prod = 1;
                    r = temp % 10;
                    for (int j = 0; j < length; j++) {
                        prod = prod * r;
                    }
                    sum = sum + prod;
                    temp = temp / 10;
                }
            }
            if (n == sum) {
                list.add(n);
            }
        }
        result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
//        System.out.println(Arrays.toString(result));
        return result;
    }
    public static void main(String args[]) {
        long memoryStart = Runtime.getRuntime().freeMemory();
        Long t0 = System.currentTimeMillis();
        int[] result = getNumbers(10000000);
        long memoryEnd = Runtime.getRuntime().maxMemory();
        long memoTaken = memoryStart - memoryEnd;
        System.out.println(memoTaken);
        Long t1 = System.currentTimeMillis();
        System.out.println("Time need to create the arrray = " + (t1 - t0));
        System.out.println("Used Memory in JVM: " + (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory()));
    }
}

  /*  private static long[][] tablNum; //таблица степеней
    private static List<Long> longL = new ArrayList<>(); //list ответов
    private static long stopNumber;

    public static long[] getNumbers(long N) {
        long[] result;
        longL.add((long) 1); // косяк
        int m = ("" + N).getBytes().length; //разряд
        stopNumber = N;

        tablNum = new long[10][m];
        tablNumbers(m); //заполняем таблицу значениями

        for (int i = 1; i <= m; i++) {
            recur(0, 0, i, i);
        }
        int stopWord = 0;
        Collections.sort(longL);
//        result = new long[longL.size()];
        for (int i = 0; i < longL.size(); i++)
            if ((longL.get(i) <= stopNumber) && (longL.get(i) > 1))
                stopWord++;
        result = new long[stopWord];
        for (int i = 0; i < stopWord; i++)
            result[i] = longL.get(i);


        return result;
    }

    private static void tablNumbers(int m) {
        for (int im = 0; im < m; im++) {
            for (int i = 0; i < 10; i++) {
                tablNum[i][im] = (long) Math.pow(i, im + 1);
            }
        }
    }

    private static void recur(long num, long sum, int m, int razr) { //long num - текущее чило, long sum - текущая сумма , int m - разряд
        --razr;                                                     //текущий разряд
        long numRazr = (long) Math.pow(10, razr);
        if (razr > 0) {                                             //проверка на последний десяток
            for (int i = 0; i < 10; i++) {
                if (num + i * numRazr < stopNumber)                // пройдет максимум последний десяток
                    recur((long) (num + i * numRazr), sum + tablNum[i][m - 1], m, razr);
                else break;
            }
        } else
            for (int i = 0; i < 10; i++) {
                if ((num + i > 1) && (sum + tablNum[i][m - 1] == num + i)) // 0 и 1 не пройдут
                    longL.add(num + i);
            }
    }

    public static void main(String[] args) {
        long mem = Runtime.getRuntime().freeMemory();
        long start = System.currentTimeMillis();
        long[] array = getNumbers(99999999l);
        long finish = System.currentTimeMillis() - start;
//        long memory = mem - Runtime.getRuntime().freeMemory();
        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        SimpleDateFormat sdf = new SimpleDateFormat("kk:mm:ss.SSS");
        System.out.println("Time = " + finish);
//        System.out.println("Time = " + sdf.format(Runtime.getRuntime().freeMemory()-start));
        System.out.println("Memory = " + memory /1024);
        System.out.println(Arrays.toString(array));
        *//*long l = 99999999l;
        long[] res = getNumbers(l);
        for (long ls : res) {
            System.out.println(ls);
        }*//*
    }
}
*/

/*

    int m;
    long sum;
    int cifra;
    String string;
        for (long l = 1; l <= N; l++) {

                string = "" + l;
                byte[] bN = string.getBytes();
                m = bN.length;
                sum = 0;

                for (int i = 0; i < m; i++) {
        cifra = bN[i] - 48;
        sum = (long) (sum + Math.pow(cifra, m));
        }
        if (l == sum) longL.add(l);

        }

        result = new long[longL.size()];
        for (int i = 0; i < longL.size(); i++) {
        result[i] = longL.get(i);
        }*/
