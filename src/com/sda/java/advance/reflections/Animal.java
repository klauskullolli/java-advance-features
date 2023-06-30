package com.sda.java.advance.reflections;

public class Animal {

//    gjitar, anfib, zvarranik
    private String type;
    private String habitat;
     ;
    private int age ;

    public Animal(String type, String habitat, int age) {
        this.type = type;
        this.habitat = habitat;
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
