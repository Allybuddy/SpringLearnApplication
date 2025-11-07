package com.example.springLearn.JavaFeatures;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum EnumTest {

    SAMSUNG(1), POCO(2), APPLE(3), SONY(4);

    EnumTest(int i) {
        this.rank = i; // assign the constructor parameter to the field
    }

    private final int rank; // make rank final

    public int getRank(){
        return this.rank;
    }

    // efficient reverse lookup by rank
    /*private static final Map<Integer, EnumTest> BY_RANK = new HashMap<>();

    static {
        for (EnumTest e : values()) {
            BY_RANK.put(e.rank, e);
        }
    }

    *//**
     * Lookup enum by rank. Returns Optional.empty() if not found.
     *//*
    public static Optional<EnumTest> fromRank(int rank) {
        return Optional.ofNullable(BY_RANK.get(rank));
    }

    *//**
     * Safe version of valueOf that returns Optional.empty() for invalid names.
     *//*
    public static Optional<EnumTest> valueOfSafe(String name) {
        try {
            return Optional.of(EnumTest.valueOf(name));
        } catch (IllegalArgumentException | NullPointerException ex) {
            return Optional.empty();
        }
    }*/

    @Override
    public String toString() {
        return name() + "(" + rank + ")";
    }

}
