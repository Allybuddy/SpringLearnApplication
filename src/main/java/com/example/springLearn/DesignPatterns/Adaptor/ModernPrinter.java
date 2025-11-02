package com.example.springLearn.DesignPatterns.Adaptor;

public class ModernPrinter implements Printer{

    @Override
    public void print() {
        System.out.println("Modern Printer is printing");
    }
}
