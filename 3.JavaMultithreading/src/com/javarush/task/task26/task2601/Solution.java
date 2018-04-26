package com.javarush.task.task26.task2601;

/* 
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
//        Integer[] array = {13, 18, 8, 5, 17, 15};
//        Integer[] sortArray = sort(array);
//        for (int j = 0; j < array.length; j++) {
//            System.out.print(array[j] + " ");
//        }
    }

    public static Integer[] sort(Integer[] array) {
        int average = findAverage(array);
        System.out.println(average);
        boolean flag;
        for (int j = 0; j < array.length; j++) {
            flag = false;
            for (int i = 0; i < array.length - j; i++) {
                if ((i != array.length - 1) && ((Math.abs(average - array[i]) > Math.abs(average - array[i + 1]))||((Math.abs(average - array[i]) > Math.abs(average - array[i + 1]))&& (array[i]>array[i+1])))) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
        //implement logic here
        return array;
    }

    private static int findAverage(Integer[] array) {
        boolean flag;
        int length = array.length;
        for (int j = 0; j < length; j++) {
            flag = false;
            for (int i = 0; i < length - j; i++) {
                if ((i != length - 1) && (array[i] > array[i + 1])) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
        if (length%2==0){
         return ((array[length/2]+array[length/2-1])/2);
        }
        return array[length / 2];
//        int min = array[0];
//        int max = array[0];
//        for (int i = 1; i < array.length; i++) {
//            if (min > array[i]) {
//                min = array[i];
//            } else if (max < array[i]) {
//                max = array[i];
//            }
//        }
//        return (min + max) / 2;
    }
}
