package com.javarush.task.task15.task1530;

/**
 * Created by winnie on 24.06.17.
 */
public class TeaMaker extends DrinkMaker {


    @Override
    void getRightCup() {
        System.out.println("Берем чашку для чая");
    }

    @Override
    void putIngredient() {
        System.out.println("Насыпаем чай");
    }

    @Override
    void pour() {
        System.out.println("Заливаем кипятком");
    }
}