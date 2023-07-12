package com.sda.java.advance.exercises;

import java.util.Map;
import java.util.TreeMap;

public class Exercise6 {


    private  static void  printMap(TreeMap<String,String> map){
        Map.Entry<String,String> fEntry =  map.firstEntry();
        System.out.printf("First -> {key: %s, value: %s}\n", fEntry.getKey(), fEntry.getValue());

        Map.Entry<String,String> lEntry =  map.lastEntry();
        System.out.printf("Last -> {key: %s, value: %s}\n", lEntry.getKey(), lEntry.getValue());



    }

    public static void main(String[] args) {

//      Tree map base on tree data structure algorithm and sort key in increasing order
        TreeMap<String,String> map = new TreeMap<>(Map.of("name", "Klaus", "surname", "Kullolli", "address", "Tirana"));

        System.out.println("map -> " + map);

        printMap(map);

    }
}
