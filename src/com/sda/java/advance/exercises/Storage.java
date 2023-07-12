package com.sda.java.advance.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * "Klaus" : [2,3,5,6]
 * "Sth" : []
 * **/


public class Storage {

    private Map<String, List<String>> map  ;

    public Storage(Map<String, List<String>> map) {
        this.map = map;
    }

    public void addToStorage(String key, String value){
//      if key does not exist put that key with an  empty arraylist
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(value);
    }

    public List<String> printValues(String key ){
        return map.get(key);
    }


    public List<String> findValues (String value){
        List<String>  keys =  new ArrayList<>();

        for(String k : map.keySet()){
            if(map.get(k).contains(value)){
                keys.add(k);
            }
        }

        return  keys.isEmpty()?null:keys;
    }


    @Override
    public String toString() {
        return "Storage{" +
                "map=" + map +
                '}';
    }
}
