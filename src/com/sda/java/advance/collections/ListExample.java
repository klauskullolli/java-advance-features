package com.sda.java.advance.collections;

import java.util.*;

public class ListExample {


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
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(4);
        arr.add(0, 6);

        System.out.println(arr);

        for (Integer e : arr) {
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

        System.out.println("list1: " + list1);

        boolean el = list1.offerFirst(2);

        System.out.println(el);
        System.out.println("list1: " + list1);

        Integer element1 = list1.element();
        System.out.println("element1: " + element1);

//        stack analogy is: FILO (first in last out)
        System.out.println("-----------------------------STACK-----------------------------------");

        Stack<Integer> stack1 = new Stack<>();
        stack1.push(2);
        stack1.push(3);
        stack1.push(7);
        System.out.println("stack1: " + stack1);
        int a = stack1.pop();
        System.out.println("a: " + a);
        System.out.println("stack1: " + stack1);
        System.out.println("Peeking: " + stack1.peek());
        System.out.println("stack1: " + stack1);
        System.out.println("index 0: " + stack1.get(0));

        System.out.println("-----------------------------QUEUE-----------------------------------");


        Pairs p1 = new Pairs();
        p1.key = 2;
        p1.value = "Hello";
        Pairs p2 = new Pairs(3, "Word");

//        PriorityQueue<Pairs> pairsQueue1 = new PriorityQueue<>(List.of(new Pairs(5,"something"),new Pairs(6, "name")));
        PriorityQueue<Pairs> pairsQueue = new PriorityQueue<>(new Comparator<Pairs>() {
            @Override
            public int compare(Pairs o1, Pairs o2) {
                return o1.value.compareTo(o2.value);
            }
        });    // vendoset rregulli per prioritetin (sorting) using functional interface Comparor
        pairsQueue.addAll(List.of(p1, p2));  // add list of elements   ,  [(2,"Hello"), (3, "Word")]

        System.out.println("pairsQueue: " + pairsQueue);

        pairsQueue.add(new Pairs(12, "something"));    // [(2,"Hello"), (3, "Word"), (12, "something")]

        System.out.println("pairsQueue: " + pairsQueue);

        System.out.println("p1: " + pairsQueue.remove(p1));  // [(3, "Wrd"), (12, "something")]

        System.out.println("pairsQueue: " + pairsQueue);
        System.out.println("poll: " + pairsQueue.poll()); //[(12, "something")]


        pairsQueue.offer(new Pairs(8, "Klaus"));  //[ (8,klaus),(12, "something")]

        System.out.println("pairsQueue: " + pairsQueue);
//  Error priority not defined
//        PriorityQueue<Pairs> pairsQueue1 = new PriorityQueue<>(List.of(new Pairs(5,"something"),new Pairs(6, "name")));

        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(new Pairs(2, "Hello")));

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>(List.of(3, 5, 6));
        arrayDeque.add(12);

        System.out.println("arrayDeque: " + arrayDeque);
        System.out.println("Peeking: " + arrayDeque.peek());
        System.out.println("Poll: " + arrayDeque.poll());

        System.out.println("arrayDeque: " + arrayDeque);

        System.out.println("Pop: " + arrayDeque.pop());

        System.out.println("Poll last : " + arrayDeque.pollLast());

        arrayDeque.addLast(15);

        System.out.println("arrayDeque: " + arrayDeque);


//        System.out.println();

    }
}
