package com.sda.java.advance.opp.taxonomy.polymorphism;


//polymorphism : each class can implement same interface and can have different overridden
// logic, also they can be declared by interface name and have initialization different
public class PolymorphismMain {

    public static void main(String[] args) {
        RemoteController r1 = new AcRemoteController("Haier");
        RemoteController r2 =new TvRemoteController("LG");
        r1.enable(true);
        r2.enable(false);
        TvRemoteController t2 = (TvRemoteController) r2 ;
        System.out.println("TV type: " + t2.getTvType());
    }
}
