package com.sda.java.advance.newFeatures.lambda;

import java.util.function.Function;

//Lambda expression is the shorter way or writing a functional interface implementation
public class LambdaExample {
    public static void main(String[] args) {

        Runnable r1 = () ->{
          System.out.println("Hello word!");
          System.out.println("SDA Tirana24");
        };

        r1.run();

        Function<Double, String> myFunction = (Double a) ->{
           return "Input value is: " + a ;
        };

        String str = myFunction.apply(2.0);
        System.out.println("Str: "+ str);

    }
}
