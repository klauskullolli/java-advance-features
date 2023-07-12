package com.sda.java.advance.exercises;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SDAHashSet<E> extends HashSet<E> {

    List<E> list;

    public SDAHashSet() {
        list =  new ArrayList<>();
    }

    @Override
    public int size() {
        return list.size();
    }



    @Override
    public boolean add(E o) {
        if(list.contains(o))
            return false;
        list.add(o);
        return  true;
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
