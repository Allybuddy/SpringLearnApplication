package com.example.springLearn.DesignPatterns.Prototype;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrototypeExample {

    public static void main(String[] args){

        Shape circle = new Circle(("red"));
        circle.draw();
        log.info("first object created");

        ShapePrototypeClient client = new ShapePrototypeClient(circle);
        var newCircle = client.cloneShape();
        log.info("object cloned successfully and printing");
        newCircle.draw();

        Shape square = new Square("blue");
        square.draw();

        ShapePrototypeClient clientSquare = new ShapePrototypeClient(square);
        var newSquare = clientSquare.cloneShape();
        newSquare.draw();
    }
}
