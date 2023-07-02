package com.sda.java.advance.generics;


/**Adding generics into class with constraint  that is extends Liquid (every
 * class that is subclass of specified interface or class or abstract class )
 * **/
public class Cup<T extends Liquid> {

    private  T liquid ;

    private Portion portion;
    public Cup(T liquid) {
        this.liquid = liquid;
    }


    public void  drink(){
        System.out.println("Drinking " + liquid);
    }

    public T getLiquid() {
        return liquid;
    }

    public void setLiquid(T liquid) {
        this.liquid = liquid;
    }

    public Portion getPortion() {
        return portion;
    }

    public void setPortion(Portion portion) {
        this.portion = portion;
    }

    public  double getPrice(){
        return  liquid.getPrice();
    }

    @Override
    public String toString() {
        return "Cup{" +
                "liquid=" + liquid +
                ", portion=" + portion +
                '}';
    }
}
