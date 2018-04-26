package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
   Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        Thread.State curentState = thread.getState();
        System.out.println(curentState);
        super.run();
        while (curentState != State.TERMINATED){
            Thread.State nowState = thread.getState();
            if (!curentState.equals(nowState)){
                curentState = nowState;
                System.out.println(curentState);
            }
        }
        this.interrupt();
    }
}
