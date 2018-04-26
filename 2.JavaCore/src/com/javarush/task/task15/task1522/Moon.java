package com.javarush.task.task15.task1522;

/**
 * Created by winnie on 22.06.17.
 */
public class Moon implements Planet {
    private static Moon instance;
    private Moon(){}
    public static Moon getInstance(){
        if (instance == null){
            instance = new Moon();
        }
        return instance;
    }
}
