package com.sda.java.advance.newFeatures.lambda;

import com.sda.java.advance.newFeatures.functionalInterface.Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

//Lambda expression is the shorter way or writing a functional interface implementation
public class LambdaExample {
    public static void main(String[] args) {

        Runnable r1 = () -> {
            System.out.println("Hello word!");
            System.out.println("SDA Tirana24");
        };

        r1.run();

        Calculator<Double> calSum = (a, b) -> a + b;

        System.out.println("Sum: " + calSum.calculate(3.0, 5.0));

        List<Integer> arr = new ArrayList<>(Arrays.asList(3, 12, 1, 3, 7, 14, 5));

        arr.sort((a1, a2) -> a1.compareTo(a2));

        System.out.println("Arr: " + arr);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread() + "is printing " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        Function<Double, String> myFunction = (Double a) -> {
            return "Input value is: " + a;
        };

        Function<Double, String> myFunction1 = (a) -> "Input value is: " + a;

        Predicate<Integer> p1 = (a) -> a > 20;

        String str = myFunction.apply(2.0);
        System.out.println("Str: " + str);
        System.out.println(p1.test(22));

    }
}
