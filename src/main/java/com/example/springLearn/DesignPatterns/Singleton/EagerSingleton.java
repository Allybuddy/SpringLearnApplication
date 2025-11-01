package com.example.springLearn.DesignPatterns.Singleton;
//Eager Initialization
public class EagerSingleton {

    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton(){

    }

    public EagerSingleton getInstance(){
        return instance;
    }


}
