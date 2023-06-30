package com.sda.java.advance.opp.taxonomy.enumExample;


public class EnumMain {
    public static void main(String[] args) {

//        Inicilaizim
       Coffee enum1 = Coffee.LATTE;

//     enum is a structural type with pre defined values
//        enum ka property default si name(), ordinal(), equals()
       System.out.println("Enum1: " + enum1);
       System.out.println("Enum1: " + enum1.name());

//       ordinal return index type according to definition order
        System.out.println("Enum1: " + enum1.ordinal());
        System.out.println("Enum1 value: " + enum1.getValue());
        System.out.println("Enum1 desc : " + enum1.getDescription());

        Coffee enum2 = Coffee.ESPRESSO;

        System.out.println("Enum2: " + enum2);
        System.out.println("Enum2: " + enum2.name());
        System.out.println("Enum2: " + enum2.ordinal());
        System.out.println("Enum2 value: " + enum2.getValue());
        System.out.println("Enum2 desc : " + enum2.getDescription());



        System.out.println(enum1.equals(Coffee.LATTE));

    }
}
