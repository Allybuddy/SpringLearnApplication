package com.example.springLearn.DesignPatterns.Adaptor;

public class PrinterAdaptor implements Printer{

    private final LegacyPrinter legacyPrinter = new LegacyPrinter();
    @Override
    public void print() {
        legacyPrinter.printDocument();
    }
}
