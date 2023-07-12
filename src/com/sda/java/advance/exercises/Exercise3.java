package com.sda.java.advance.exercises;

import java.util.LinkedHashMap;
import java.util.Map;

public class Exercise3 {



    private static  void  printMapSameTypeNumber(Map<String , Number> map){

        int i = 0;
        int l =  map.size();
        boolean isInt =  false;

//        Check first element  value form map for its data type if is instance of integer
//        And take as true same type for other keys
        for(String k : map.keySet()){
            if(map.get(k) instanceof Integer){
                isInt = true;
            }
            break;

        }

        for(String k : map.keySet()){
            if(i==l-1){
                if(isInt){
                    System.out.printf("Key: %s, Value %d.\n", k, map.get(k) );
                }
                else{
                    System.out.printf("Key: %s, Value %.2f.\n", k, map.get(k) );
                }
            }
            else{
                if(isInt){
                    System.out.printf("Key: %s, Value %d,\n", k, map.get(k) );
                }
                else{
                    System.out.printf("Key: %s, Value %.2f,\n", k, map.get(k) );
                }
            }

            i++;

        }

    }

    private static  void  printMap(Map<String , Number> map){

        int i = 0;
        int l =  map.size();
        boolean isInt =  false;


        for(String k : map.keySet()){

            if(map.get(k) instanceof Integer){
                isInt = true;
            }

            if(i==l-1){
             if(isInt){
                System.out.printf("Key: %s, Value %d.\n", k, map.get(k) );
             }
             else{
                 System.out.printf("Key: %s, Value %.2f.\n", k, map.get(k) );
             }
            }
            else{
                if(isInt){
                    System.out.printf("Key: %s, Value %d,\n", k, map.get(k) );
                }
                else{
                    System.out.printf("Key: %s, Value %.2f,\n", k, map.get(k) );
                }
            }

            i++;

            isInt = false ;


        }

    }

    public static void main(String[] args) {

        Map<String, Number> map = new LinkedHashMap<>(Map.of("Klaus", 22, "Filani" , 44.2, "Ciku", 15.33 ));

        printMap(map);


        System.out.println("----------------------------------------------------------------");

        Map<String, Number> map1 = new LinkedHashMap<>(Map.of("Klaus", 22.2, "Filani" , 44.2, "Ciku", 15.33 ));
        printMapSameTypeNumber(map1);


    }
}
