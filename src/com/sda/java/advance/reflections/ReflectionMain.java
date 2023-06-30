package com.sda.java.advance.reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionMain {


    public static void main(String[] args) {

        try {
//  class name: com.sda.java.advance.reflections.Animal
            Class c1 = Class.forName(Animal.class.getName());
            System.out.println("Class name: " + Animal.class.getName());
            Constructor con1 =  c1.getConstructor(String.class, String.class, int.class) ;
            Animal a1 =  (Animal) con1.newInstance("gjitar", "tropik", 2);
            Method getType = c1.getDeclaredMethod("getType")  ;
            String type = (String) getType.invoke(a1);
            System.out.println("Type is: " + type);

//            Animal a1 = new Animal("gjitar", "tropik", 2);
//            System.out.println("Type is: " + a1.getType());

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }


    }
}
