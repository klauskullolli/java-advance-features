package com.sda.java.advance.exercises;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercise12 {

    public static void main(String[] args) {
        Manufacturer m1 = new Manufacturer("Benz", 1800 , "Germany");
        Manufacturer m2 = new Manufacturer("AMG", 1890 , "Germany");

        Car c1 = new Car("W213 63s", "W213" ,2018, 50000.0 , new ArrayList<>(Arrays.asList(m1,m2)), EngineType.V8);
        Car c2 = new Car("S class 63s", "W225" ,2018, 60000.0 , new ArrayList<>(Arrays.asList(m1,m2)), EngineType.V8);

        System.out.println("C1 -> " + c1);

        System.out.println("C1 hash value -> " + c1.hashCode());
        System.out.println("C1 equal C2 -> " + c1.equals(c2));
        System.out.println("C1 equal copy of C1 -> " + c1.equals(new Car("W213 63s", "W213" ,2018, 50000.0 , new ArrayList<>(Arrays.asList(m1,m2)), EngineType.V8)));



    }

}
