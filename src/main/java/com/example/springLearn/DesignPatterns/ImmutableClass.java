package com.example.springLearn.DesignPatterns;

import java.util.ArrayList;
import java.util.List;
//Immutable class
public final class ImmutableClass {

    private final String firstName;
    private final String lastName;
    private final List<String> list;

    public ImmutableClass(String firstName, String lastName, List<String> list){
        this.firstName = firstName;
        this.lastName = lastName;
        //new is used coz while copying it will copy the reference
        this.list = new ArrayList<>(list);
    }

    // no setters required

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<String> getList() {
        //
        return new ArrayList<>(list);
    }




}
