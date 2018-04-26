package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        for (Thread theard : threads) {
            switch (theard.getState().toString()) {
                case "NEW":
                    theard.start();
                    break;
                case "WAITING":
                    theard.notify();
                    break;
                case "RUNNABLE":
                    theard.isInterrupted();
                    break;
                case "TERMINATED":
                    System.out.println(theard.getPriority());
            }
        }
        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) {
    }
}
