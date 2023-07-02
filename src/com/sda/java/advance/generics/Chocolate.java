package com.sda.java.advance.generics;

public class Chocolate implements Liquid{

    public enum ChocolateType {
        WHITE_HOT,
        WHITE_COLD,
        BLACK_HOT,
        BLACK_COLD
    }


    private  ChocolateType chocolateType;

    public double price;

    public Chocolate(ChocolateType chocolateType, double price) {
        this.chocolateType = chocolateType;
        this.price = price;
    }


    public ChocolateType getChocolateType() {
        return chocolateType;
    }

    public void setChocolateType(ChocolateType chocolateType) {
        this.chocolateType = chocolateType;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Chocolate{" +
                "chocolateType=" + chocolateType +
                ", price=" + price +
                '}';
    }
}
