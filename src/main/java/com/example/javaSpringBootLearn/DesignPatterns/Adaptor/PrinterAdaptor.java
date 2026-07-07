package com.example.javaSpringBootLearn.DesignPatterns.Adaptor;

public class PrinterAdaptor implements Printer{

    private final LegacyPrinter legacyPrinter = new LegacyPrinter();
    @Override
    public void print() {
        legacyPrinter.printDocument();
    }
}
