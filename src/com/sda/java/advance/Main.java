package com.sda.java.advance;

import com.sda.java.advance.opp.taxonomy.Mercedes;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        //        System.out.println("Hello world!");
//        CarType t1 = CarType.SEDAN;
//
//        System.out.printf("value: %d\n", t1.ordinal());
//        System.out.println("Name: "+ t1.getTypeStr());

        try {
            Class myClass  =  Class.forName(Mercedes.class.getName()) ;
            Constructor myConstructor = myClass.getConstructor(String.class, String.class, String.class, String.class, float.class, String.class);

            Method myClassMethod= myClass.getMethod("getType") ;



            Mercedes mercedes =  (Mercedes) myConstructor.newInstance("sedan", "black" , "w211" , "2199cc", 7.7f, "null");

            String type  = (String) myClassMethod.invoke(mercedes);

            System.out.println(type);
        } catch (Exception e) {
//            throw new RuntimeException(e);

            System.out.println("Exception type: " + e.getClass().getName());
            System.out.println(e);
        }

    }
}