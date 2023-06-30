package com.sda.java.advance.opp.taxonomy;

//if we implement a interface in an abstract class
// overriding it is not necessary
public abstract class Car implements Vehicle{

    //    // Type can be sedan, hatchback, suv etc
    private String type;

    private String color ;


//    Should always be overridden where is extended this class
    public Car(String type, String color){
        this.type = type;
        this.color = color;
    }


        //Abstract classes can have
    public void changeColor(String color){
        this.color = color;
        System.out.printf("Car color changed to %s\n", color);
    }

    //    //  Can be declared public , protected but not private
    protected abstract void  runEngine();

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }
}


//public abstract class Car  {
//
//
//    // Type can be sedan, hatchback, suv etc
//    private String type;
//
//    private String color ;
//
//    public Car(String type, String color){
//        this.type = type;
//        this.color = color;
//    }
//
//
//    public String getColor() {
//        return color;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    //  Can be declared public , protected but not private
//    protected abstract void  runEngine();
//
//    //Abstract classes can have
//    public void changeColor(String color){
//        this.color = color;
//        System.out.printf("Car color changed to %s\n", color);
//    }
//
//    public static float calculateConsumedLiter(float consumePerHundred ,  float km){
//        return consumePerHundred*km/ 100 ;
//    }
//
//
//
//
//}
