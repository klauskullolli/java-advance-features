package com.sda.java.advance.exercises;

public class Exercise5 {

    public static void main(String[] args) {

        SDAHashSet<Integer> s1 = new SDAHashSet<>();
        s1.add(12);
        s1.add(14);
        s1.add(5);

        System.out.println(s1);

        s1.remove(12);
        System.out.println(s1);

    }
}
