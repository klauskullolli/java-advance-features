package com.sda.java.advance.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cafe {

/**
 * This is a generic method that accept as attribute a list of cups that has a generic type
 * with constrain that super class is a Liquid type
 * Method find the most expensive cup and return it
 * **/
    private static <T extends Liquid> Cup<T> getMostExpensiveCup(List<Cup<T>> cups){

        Cup<T> mostExpensiveCup = cups.get(0);

        for(Cup c : cups){
            if(c.getLiquid().getPrice()>mostExpensiveCup.getLiquid().getPrice()){
                mostExpensiveCup  = c;
            }
        }
        return  mostExpensiveCup;
    }

    public static void main(String[] args) {

//        Liquid t1 =  new Tea(Tea.TeaType.KAMOMIL, 70);
        Cup<Liquid> cup1 = new Cup<>(new Tea(Tea.TeaType.BORONIC, 50));
        cup1.setPortion(Portion.SMALL);

        cup1.drink();

        Util<String, String> util =  new Util<String, String>() {

            @Override
            public String getValue(Map<String, String> map, String key) {
                return map.get(key);
            }
        } ;

        Map<String, String>map1 =  new HashMap<>(Map.
                of("name", "Klaus",
                        "surname", "Kullolli")
        ) ;

        System.out.println("Name: " + util.getValue(map1, "name"));
        System.out.println("Surname: " + util.getValue(map1, "surname"));
        System.out.println("Address: " + util.getValue(map1, "address"));

        Cup<Liquid> cup2 = new Cup<>(new Tea(Tea.TeaType.BORONIC, 100));
        cup1.setPortion(Portion.MEDIUM);

        Cup<Liquid> cup3 = new Cup<>(new Tea(Tea.TeaType.BORONIC, 150));
        cup1.setPortion(Portion.BIG);

        Cup<Liquid> cup4 =  new Cup<>(new Chocolate(Chocolate.ChocolateType.BLACK_HOT, 200)) ;
        cup4.setPortion(Portion.MEDIUM);

        List<Cup<Liquid>> cups  =  new ArrayList<>(List.of(cup1,cup2,cup3,cup4)) ;



        System.out.println("Most expensive cop is: " + getMostExpensiveCup(cups));


    }
}
