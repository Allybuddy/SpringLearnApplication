package com.example.springLearn.DesignPatterns.Prototype;

public class ShapePrototypeClient {

    private Shape shape;

    public ShapePrototypeClient(Shape shape){
        this.shape = shape;
    }

    public Shape cloneShape(){
        return shape.clone();
    }
}
