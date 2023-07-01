package com.sda.java.advance.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapsExample {
    public static void main(String[] args) {
        HashMap<String, String> map1 = new HashMap<>(){
            {
                put("name", "Klaus");
                put("surname", "Kullolli");
            }
        } ;
        map1.put("address", "Tirana");
        map1.put("number", "069111111");

        System.out.println("map1: " + map1);

        map1.put("number", "068111111");

        System.out.println("map1: " + map1);

        System.out.println("name: "+ map1.get("name"));
        System.out.println("surname: "+ map1.get("surname"));

        String number = map1.remove("number");
        System.out.println("number: "+ number);

        System.out.println("map1: " + map1);

        for(String k : map1.keySet()){
            System.out.print(k + " ");
        }
        System.out.println();

        for(String v : map1.values()){
            System.out.print(v + " ");
        }

        System.out.println();

        for(Map.Entry<String, String> entry: map1.entrySet()){
            System.out.printf("{k:%s, v:%s}, ", entry.getKey(), entry.getValue());
        }

        System.out.println();

        for(String k: map1.keySet()){
            System.out.printf("{k:%s, v:%s}, ", k, map1.get(k));
        }

        System.out.println();

//linked hash sets follow the order of key, value pair inputting
        LinkedHashMap <String, String> map2 =  new LinkedHashMap<>(Map.
                of("name","Klaus",
                        "surname","Kullolli",
                        "address", "Tirana"

                )
        );

        System.out.println("map2: " + map2);




    }
}
