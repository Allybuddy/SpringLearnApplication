package com.example.javaSpringBootLearn.Practice;

import java.util.List;

public class Generics {

    public static void main(String[] args){

        System.out.println("Application Started");

        //generic method
        List<String> strLs = List.of("hi","hello","bye","tata","NA");
        printAll(strLs);

        List<Integer> intLs = List.of(1,2,3,4,5);
        printAll(intLs);

        //generic class
        Test<String> strVal = new Test<>();
        strVal.setVariable("Allvin");
        System.out.println(strVal.getVariable());

        Test<Integer> intVal = new Test<>();
        intVal.setVariable(13);
        System.out.println(intVal.getVariable());

        System.out.println("Application Ended");
    }

    public static <T> void printAll(List<T> ls){
        for(T obj : ls){
            System.out.println(obj);
        }
    }
    //                   extends Number -> to restrict the type
    static class Test<T>{
        T variable;

        T getVariable(){
            return variable;
        }

        void setVariable(T variable){
            this.variable = variable;
        }
    }

   /* Type Erasure -> The compiler replaces all generic type parameters with their bounds (or Object if unbounded)
    during compilation. The bytecode contains only ordinary classes, ensuring backward compatibility.*/

   /* Wildcards (?)
    Wildcards represent an unknown type and are highly useful in method parameters.
    Unbounded Wildcard (<?>): Stands for any type.
    Upper Bounded Wildcard (<? extends T>): Accepts type T or its subclasses.
    Lower Bounded Wildcard (<? super T>): Accepts type T or its superclasses.*/
}
