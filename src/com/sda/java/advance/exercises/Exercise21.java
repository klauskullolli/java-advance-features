package com.sda.java.advance.exercises;

public class Exercise21 {

    public static void main(String[] args) {
        Cone c1 =  new Cone(2,3);
        Cube c2 =  new Cube(4);

        System.out.printf("c1 area: %.2f\n" , c1.calculateArea());
        System.out.printf("c1 volume: %.2f\n", c1.calculateVolume());

        System.out.printf("c2 area: %.2f\n", c2.calculateArea());
        System.out.printf("c2 volume: %.2f\n", c2.calculateVolume());
    }
}
