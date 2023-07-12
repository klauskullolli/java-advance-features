package com.sda.java.advance.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise4 {
    public static void main(String[] args) {

        Map<String, List<String>> map =  new HashMap<>();
        map.put("Klaus", new ArrayList<>(List.of("Hello", "Hi", "there", "here")));
        map.put("Sth", new ArrayList<>(List.of("nice", "there", "whats up")));

        System.out.println("map -> " + map);

        Storage s1 =  new Storage(map);

        s1.addToStorage("Sth", "filani");

        System.out.println("s1 -> "  + s1);

        s1.addToStorage("sda", "student");

        System.out.println("s1 -> " + s1);


        System.out.println("Klaus values -> " + s1.printValues("Klaus"));

        System.out.println("Keys that contain there value -> " + s1.findValues("there"));



    }
}
