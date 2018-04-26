package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {

    private Thread thread;
    @Override
    public void run() {
        try {
            while (!thread.isInterrupted()) {
                Thread.sleep(0);
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            //System.out.println(e.getMessage());
        }
    /*    try {
            while (!thread.isInterrupted()) {
                thread.sleep(0);
                System.out.println(Thread.currentThread().getName());
                thread.sleep(10);
            }
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }*/
    }

    @Override
    public void start(String threadName) {
        this.thread = new Thread(this);
        this.thread.setName(threadName);
        this.thread.start();
/*
        thread = new Thread(threadName);
        thread.start();*/
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
