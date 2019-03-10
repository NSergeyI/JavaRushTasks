package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Алгоритмы-числа
просто перебор 40
*/
public class Solution {
    private static HashMap<Integer, HashMap<Integer, Long>> tablStep;

    public static long[] getNumbers(long N) {
        long[] result = null;
        List<Long> out = new ArrayList<>();
        long curentNumber = 1L;
        int number = getRazr(N);
        tablStep = getTable(number);
        while (curentNumber < N) {
            if (checkNumber(curentNumber)) {
                out.add(curentNumber);
            }
            curentNumber++;
        }
        result = convert(out);
        return result;
    }

    private static boolean checkNumber(long n) {
        boolean result = false;
        List<Integer> number = getArrayNumber(n);
        if (number.isEmpty()) {
            return result;
        }
        long resultLong = getSum(number);
        if (n == resultLong) {
            result = true;
        }
        return result;
    }

    private static HashMap<Integer, HashMap<Integer, Long>> getTable(int number) {
        HashMap<Integer, HashMap<Integer, Long>> result = new HashMap<>();
        for (int i = 0; i < number + 1; i++) {
            HashMap<Integer, Long> curent = new HashMap<>();
            for (int k = 0; k < 10; k++) {
                curent.put(k, (long) Math.pow(k, i));
            }
            result.put(i, curent);
        }
        return result;
    }

    private static long getSum(List<Integer> number) {
        long result = 0;
        int size = number.size();
        for (int curent : number) {
            result = (result + tablStep.get(size).get(curent));
        }
        return result;
    }

    private static List<Integer> getArrayNumber(long n) {
        List<Integer> result = new ArrayList<>();
        int pre = 0;
        while (n > 0) {
            int cur = (int) (n % 10);
            result.add(cur);
            n = n / 10;
            if (pre > cur) {
                result.clear();
                break;
            }
            pre = cur;
        }
        return result;
    }

    private static int getRazr(Long n) {
        int result = 0;
        while (n > 0) {
            n = n / 10;
            result++;
        }
        return result;
    }

    private static long[] convert(List<Long> in) {
        long[] result = new long[in.size()];
        for (int i = 0; i < in.size(); i++) {
            result[i] = in.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        long[] n = getNumbers(8506L);
        for (long curent : n) {
            sb.append(curent).append(" ");
        }
        System.out.println(sb.toString());
        long time = System.currentTimeMillis() - startTime;
        System.out.println(time);
    }
}
