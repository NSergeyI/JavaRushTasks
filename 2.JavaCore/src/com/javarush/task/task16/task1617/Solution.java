package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int countSeconds = 4;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
//        clock.start();
       Thread.sleep(3500);
//       try {
       clock.interrupt();
//       catch (Exception ex) {
//           System.out.println("Прервано!");

//       }
        //add your code here - добавь код тут
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            while (true){
                try {
                    if (countSeconds > 0) {
                        System.out.print(countSeconds + " ");
                        countSeconds--;
                        sleep(1000);
                    } else {
                        System.out.println("Марш!");
                        return;
                    }
                } catch (Exception ex) {
                   System.out.println("Прервано!");
                   return;
                }
            }
                        //add your code here - добавь код тут
        }
    }
}
