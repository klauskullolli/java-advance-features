package com.sda.java.advance.newFeatures.functionalInterface;

//This is a functional interface
//Functional interfaces are used for functional programing
//Functional interfaces have only one method
public interface Calculator<T> {

    T calculate(T a, T b);

}
