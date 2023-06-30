package com.sda.java.advance.opp.taxonomy;

public class BMW extends  Car{
    public BMW(String type, String color) {
        super(type, color);
    }

    @Override
    protected void runEngine() {

    }

    @Override
    public String getFuelType() {
        return null;
    }
}
