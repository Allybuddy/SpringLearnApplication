package com.example.springLearn.DesignPatterns.Prototype;

public class Circle implements Shape{

    private String colour;

    public Circle(String colour){
        this.colour = colour;
    }

    @Override
    public void draw() {
        System.out.println("circle drawn - colour " + colour);
    }

    // we can write "Shape" as well in place of "Circle" return type
    @Override
    public Circle clone() {
        return new Circle(this.colour);
    }
}
