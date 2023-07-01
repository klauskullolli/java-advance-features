package com.sda.java.advance.collections;

import java.util.*;

public class ListExample {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(4);
        arr.add(0,6);

        System.out.println(arr);

        for (Integer e : arr){
            System.out.print(e + " ");
        }
        System.out.println();
        ArrayList<Integer> arr2  = new ArrayList<>(Arrays.asList(2,4,5,6));
        for(int i =10 ; i<20; i++){
            arr2.add(i);
        }
        arr.addAll(2, Arrays.asList(1, 2, 3, 4, 5)) ;

        System.out.println("arr: " + arr);

        arr2.addAll(arr);

        System.out.println("arr2: " + arr2);

        System.out.println("arr[2]: "+ arr.get(2));

        System.out.println("arr has 20 " + arr.contains(20));

        arr2.remove(2);

        System.out.println("arr2: " + arr2);

//        arr2.remove(new Integer(12));
//
//        System.out.println("arr2: " + arr2);

        ArrayList<String> stringArray = new ArrayList<>(List.of("Klaus", "Anonymous", "Hello")) ;
        ArrayList<String> stringArray1 = new ArrayList<>(Arrays.asList("Klaus", "Anonymous", "Hello")) ;

        stringArray.add("Word");
        stringArray.add("sth");

        System.out.println("stringArray : " + stringArray);

        System.out.println("stringArray has Word: " + stringArray.contains("Word"));

        stringArray.remove("Word");
        System.out.println("stringArray : " + stringArray);


//        Sorting from small to the biggest

        stringArray.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println("stringArray : " + stringArray);


        //        Sorting from biggest to the smallest
        stringArray.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        System.out.println("stringArray : " + stringArray);

        System.out.println("klaus".compareTo("sth"));
        System.out.println("klaus".compareTo("klaus"));
        System.out.println("klaus".compareTo("klaui"));


        System.out.println("Index of sth in stringArray: "+ stringArray.indexOf("sth"));

        System.out.println("--------------------LINKED LIST----------------------------");

// Note: it is better than arraylist for removal and addition of elements
//        But is worse than arraylist for accessing elements at specified index
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(2);         // {2}
        list1.addFirst(7);  // {7,2}
        list1.addLast(5);   // {7,2,5}
        list1.add(1, 8); //{7,8,2,5}
        list1.add(8);  // {7,8,2,5,8}

        System.out.println("list1: "+ list1);

        boolean el  =  list1.offerFirst(2);

        System.out.println(el);
        System.out.println("list1: "+ list1);

        Integer element1 = list1.element() ;
        System.out.println("element1: " + element1);







    }
}
