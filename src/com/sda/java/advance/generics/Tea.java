package com.sda.java.advance.generics;

public class Tea implements  Liquid{

    public enum TeaType{
        KAMOMIL,
        BORONIC,
        LIMON
    }

    private  TeaType type;

    private  double price;

    public Tea(TeaType type, double price) {
        this.type = type;
        this.price = price;
    }

    public TeaType getType() {
        return type;
    }

    public void setType(TeaType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tea{" +
                "type=" + type +
                ", price=" + price +
                '}';
    }
}
