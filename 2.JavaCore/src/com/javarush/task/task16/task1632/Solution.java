package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static
    {
        Thread1 thread1 = new Thread1();
        threads.add(thread1);
        Thread2 thread2 = new Thread2();
        threads.add(thread2);
        Thread3 thread3 = new Thread3();
        threads.add(thread3);
        Thread4 thread4 = new Thread4();
        threads.add(thread4);
        Thread5 thread5 = new Thread5();
        threads.add(thread5);
    }

    public static void main(String[] args) {


    }

    public static class Thread1 extends Thread {

        @Override
        public void run() {
            while (true){

            }
        }
    }

    public static class Thread2 extends Thread {
        @Override
        public void run() {
           try {
               while (true) {
                   Thread.sleep(0);
               }
           }catch (InterruptedException ex){
               System.out.println("InterruptedException");
           }

        }
    }

    public static class Thread3 extends Thread {
        @Override
        public void run() {
            while (true){
                try {System.out.println("Ура");
                    Thread.sleep(500);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Thread4 extends Thread implements Message {

        @Override
        public void run() {
        }

        @Override
        public void showWarning() {
        this.interrupt();
        }
    }

    public static class Thread5 extends Thread {

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s = "";
            int res = 0;
            while (true){
                try {
                    s = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s.equals("N")) {
                        break;
                } else {
                    res += Integer.parseInt(s);
                }
            }
            System.out.println(res);
        }
    }
}