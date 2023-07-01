package com.sda.java.advance.collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class SetExamples {

   private static class Pairs {
        int key;
        String value;

        public Pairs() {
        }

        public Pairs(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{key: " + key + ", value: " + value + "}";
        }

        @Override
        public boolean equals(Object obj) {
              Pairs p = (Pairs) obj;
//            return key==((Pairs) obj).key &&  value.equals(((Pairs) obj).value);
            return key == p.key && value.equals(p.value);

        }
    }

    public static void main(String[] args) {

        System.out.println("----------------------------------SETS---------------------------");
//  vlerat jan uniq  dhe index vendoset ne bast te funksionit hash te parapercaktuar nga sdk
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(3);
        set1.add(5);
        set1.addAll(List.of(7,12,1));

        set1.add(6);
        set1.add(7);

        set1.addAll(List.of(23,24,11,14,0));

        System.out.println("set1: " + set1);
//        System.out.println("set1: " + set1);
        for (Integer e : set1){
            System.out.print(e + " ");
        }
        System.out.println();
        System.out.println("Has value 12: " + set1.contains(12));
        set1.remove(12);
        System.out.println("set1: " + set1);

//        order does not matter  when comparing sets
        HashSet<Integer> set2 = new HashSet<>(List.of(1,2,4)) ;
        HashSet<Integer> set3 = new HashSet<>(List.of(1,4,2)) ;

        System.out.println(set2.equals(set2));

        TreeSet<Integer> treeSet  = new TreeSet<>(List.of(2,4,1)) ;

        System.out.println("treeSet: " + treeSet);

        TreeSet<Pairs> pairSet =  new TreeSet<>(new Comparator<Pairs>() {
            @Override
            public int compare(Pairs o1, Pairs o2) {
                return o1.value.compareTo(o2.value);
            }
        });
        pairSet.addAll(List.of(new Pairs(2,"hello"), new Pairs(3,"hi")));

        System.out.println("pairSet: " + pairSet);

//  ceiling return the smallest from those which are greater or equal than given value
//        instead return null
       System.out.println("ceiling: "+  pairSet.ceiling(new Pairs(4, "book")));
       System.out.println("ceiling: "+  pairSet.ceiling(new Pairs(4, "school")));

        //  floor return the biggest from those which are smaller or equal than given value
        //        instead return null
        System.out.println("floor: "+  pairSet.floor(new Pairs(4, "book")));
        System.out.println("floor: "+  pairSet.floor(new Pairs(4, "school")));
    }
}
