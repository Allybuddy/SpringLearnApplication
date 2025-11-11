package com.example.springLearn.DesignPatterns.Factory;

public class FactoryExample {

    public static void main(String[] args){

        VehicleFactory twoWheelerFactory = new TwoWheelerFactory();
        FactoryClient twoWheelerClient = new FactoryClient(twoWheelerFactory);
        var twoWheelerObj = twoWheelerClient.getVehicle();
        twoWheelerObj.printVehicle();


    }
}
