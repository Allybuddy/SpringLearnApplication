package com.example.javaSpringBootLearn.DesignPatterns.Factory;

public class FourWheelerFactory implements VehicleFactory{

    @Override
    public Vehicle createVehicle() {
        return new FourWheelerVehicle();
    }
}
