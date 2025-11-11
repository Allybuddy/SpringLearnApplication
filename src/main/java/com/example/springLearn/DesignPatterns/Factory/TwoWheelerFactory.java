package com.example.springLearn.DesignPatterns.Factory;

public class TwoWheelerFactory implements VehicleFactory{

    @Override
    public Vehicle createVehicle() {
        return new TwoWheelerVehicle();
    }
}
