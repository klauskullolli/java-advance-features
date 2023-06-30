package com.sda.java.advance.opp.taxonomy;

public enum CarType {
    SEDAN("HATCHBACK"),
    HATCHBACK("HATCHBACK"),
    SUV("HATCHBACK"),
    CABRIOLET("HATCHBACK");

    private String typeStr;

    CarType(String typeStr) {
        this.typeStr = typeStr;
    }

    public String getTypeStr() {
        return typeStr;
    }



}
