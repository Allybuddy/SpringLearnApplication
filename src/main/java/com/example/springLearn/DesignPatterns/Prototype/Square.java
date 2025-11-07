package com.example.springLearn.DesignPatterns.Prototype;

public class Square implements Shape{

    private String colour;

    public Square(String colour){
        this.colour = colour;
    }

    @Override
    public void draw() {
        System.out.println("square drawn - colour " + colour);
    }

    @Override
    public Shape clone() {
        return new Square(this.colour);
    }
}
