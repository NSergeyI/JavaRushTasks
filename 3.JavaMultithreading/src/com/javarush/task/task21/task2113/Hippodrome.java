package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by winnie on 26.07.17.
 */
public class Hippodrome {
    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    static Hippodrome game;

    public void move() {
        for (Horse horse:horses){
            horse.move();
        }
    }

    public void print() {
        for (Horse horse:horses){
            horse.print();
        }
        for (int i = 0; i <10 ; i++) {
            System.out.println();
        }
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public Horse getWinner(){
        double max = 0;
        int ind = 0;
        for (int i = 0; i<horses.size(); i++){
            if (max<horses.get(i).distance) {
                ind = i;
                max = horses.get(i).distance;
            }
        }
        return horses.get(ind);
    }

    public void printWinner(){
        System.out.println("Winner is "+getWinner().name+"!");
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<>());
        game.getHorses().add(new Horse("Horse1", 3, 0));
        game.getHorses().add(new Horse("Horse2", 3, 0));
        game.getHorses().add(new Horse("Horse3", 3, 0));
        game.run();
        game.printWinner();


    }
}
