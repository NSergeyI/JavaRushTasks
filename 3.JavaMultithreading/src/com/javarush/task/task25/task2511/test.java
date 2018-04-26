package com.javarush.task.task25.task2511;

import java.util.TimerTask;

/**
 * Created by winnie on 04.04.18.
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution(new TimerTask() {
            @Override
            public void run() {
                System.out.println("++=++");
            }
        });
        solution.run();
        System.out.println("===");
    }
}
