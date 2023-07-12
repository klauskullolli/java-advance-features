package com.sda.java.advance.exercises;

import java.util.Stack;

public class Weapon {

    private Stack<String> magazine;

    private final int maxSize;

    private int size ;

    public Weapon(int maxSize) {
       this.maxSize = maxSize;
       size = 0 ;
       magazine = new Stack<>();
    }



    public boolean loadBullet(String bullet) {
        if (size < maxSize) {
            magazine.push(bullet);
            size++;
            return true;
        }
        return  false;
    }

    public boolean isLoaded(){
        return size==0?false:true;
    }


    public void shot(){
        if(isLoaded()){
            String bullet  = magazine.pop();
            System.out.println(bullet);
            size--;
        }
        else {
            System.out.println("empty magazine");
        }
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "magazine=" + magazine +
                ", maxSize=" + maxSize +
                ", size=" + size +
                '}';
    }
}
