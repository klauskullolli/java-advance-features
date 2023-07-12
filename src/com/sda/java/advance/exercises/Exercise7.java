package com.sda.java.advance.exercises;

public class Exercise7 {
    public static void main(String[] args) {

        Weapon w1 = new Weapon(4);

        System.out.println("Loaded: " +  w1.isLoaded());

        w1.loadBullet("Klaus") ;

        System.out.println("Loaded: " +  w1.isLoaded());

        w1.loadBullet("Sth");

        w1.loadBullet("Hello");

        w1.loadBullet("word");

        System.out.println("w1 -> " + w1);

         for(int i = 0 ; i<5; i++){
             w1.shot();
         }

        System.out.println("Loaded: " +  w1.isLoaded());


    }
}
