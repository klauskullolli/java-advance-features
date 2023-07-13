package com.sda.java.advance.exercises;

public class Exercise8 {

    public static void main(String[] args) {

        Parcel p1 = new Parcel(40, 40 , 40 , 20 , false );

        Validator validator =  new ValidatorImp();

        System.out.println("P1 validator: " + validator.validate(p1));

        Parcel p2 = new Parcel(30, 40 , 40 , 20 , false );

        System.out.println("P1 validator: " + validator.validate(p2));


    }
}
