package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

public class Solution {
    static int count = 15;
    static volatile int countCreatedThreads = 0;

    public static void main(String[] args) {
//        while (Solution.count > Solution.countCreatedThreads)
//         {

            System.out.println(new GenerateThread());
//        }
    }

    public static class GenerateThread extends Thread {
        public GenerateThread() {
            super(String.valueOf(++countCreatedThreads));
            start();
        }

        @Override
        public String toString() {
            return (getName() + " created");
        }

        @Override
        public void run() {
                 if (Solution.count > Solution.countCreatedThreads)
                    System.out.println(new GenerateThread());


            //            while (true){
//                if (Solution.count < Solution.countCreatedThreads){
////                    new GenerateThread();
////                    System.out.println(this);
//                }
//            }
        }
    }
}
