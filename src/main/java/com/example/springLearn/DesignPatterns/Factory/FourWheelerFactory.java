package com.example.springLearn.DesignPatterns.Factory;

public class FourWheelerFactory implements VehicleFactory{

    @Override
    public Vehicle createVehicle() {
        return new FourWheelerVehicle();
    }
}
