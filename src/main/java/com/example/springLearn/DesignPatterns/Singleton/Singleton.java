package com.example.springLearn.DesignPatterns.Singleton;

import java.util.Objects;
//Lazy Initialization
public class Singleton {

    //static so that it can be accessed with class name
    private static Singleton instance = null;

    //private constructor so that it cannot be instantiated from outside
    private Singleton(){
    }

    //to create an instance
    //synchronized is used to make it thread safe
    public static synchronized Singleton getInstance(){
        if(Objects.isNull(instance)){
            instance = new Singleton();
        }
        return instance;
    }
}
