package com.example.springLearn.DesignPatterns.Adaptor;

public class AdaptorClient {

    /*
        Adapter Design Pattern is a structural pattern that acts as a bridge between two
        incompatible interfaces, allowing them to work together. It is especially useful for
        integrating legacy code or third-party libraries into a new system.
     */

    public static void clientCode(Printer printer){
        printer.print();
    }

    public static void main(String [] args){

        PrinterAdaptor printer = new PrinterAdaptor();
        clientCode(printer);
    }
}
