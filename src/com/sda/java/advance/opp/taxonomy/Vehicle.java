package com.sda.java.advance.opp.taxonomy;

public interface Vehicle {

//    each declared variable is final in interface
    String fuel = "Diesel" ;


//    interface always has abstract methods defined
//    abstract keyword is not necessary
     String getFuelType();


//      public static void getDefaultFuel(){
//        System.out.println("Default fuel is: " + fuel);
//    }


}
