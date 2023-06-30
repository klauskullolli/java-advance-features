package com.sda.java.advance.opp.taxonomy;

public class CarMain {

       class  InnerClass{
         String key ;
         String value;

    }

//    Nje me class inner statike mund ta inicializojm vetem ne static method
//    Kurse jo statike ne method jo statike
    public  void methodOfInnerClass(){
           InnerClass newObject = new InnerClass();
    }


//    kur krijojme nje klase brenda methodes ajo quhet nje local class
//    mund te aksesohet e te inicializohet vetem brenda ksaj methode ku krijohet
    public static  void methodOfLocalClass(){
           class LocalClass{
               String key ;
               String value;
           }

           LocalClass l1 =  new LocalClass();
           l1.key = "something";
           l1.value = "somethingElse";

           System.out.println("Local class l1 has key: "+l1.key + " and value: " + l1.value);
    }

//    static  void method2(){
//           LocalClass l2 = new LocalClass();
//    }

    public static void main(String[] args) {

//Abstract classes can not be initialized directly
//        Car car1 = new Car();

        Mercedes m1 = new Mercedes("sedan","blue","w211","1998cc",6.5f,null);
//
//        m1.runEngine();

//nese duam te thrrasim nje inner class nga nje klase tjeter duhet ta deklarojme statike
// qe te thirret ne formen si me poshte
        Mercedes.Company company = new Mercedes.Company();
        company.companyName = "Mercedes Benz";
        company.foundingYear = 1880;

        System.out.printf("Company Name: %s, Founding year: %d\n", company.companyName, company.foundingYear);


        Mercedes.Owner myOwner = m1.initializeOwner();
        myOwner.name = "Klaus";
        myOwner.surname = "Kullolli";

        System.out.println("myOwner name is "+ myOwner.name + " and surname is " + myOwner.surname );

        Mercedes.Owner o2 = Mercedes.initializeOwnerStatic();
        o2.name = "anonymous";
        o2.surname = "anonymous";
        System.out.println("myOwner name is "+ o2.name + " and surname is " + o2.surname );

        methodOfLocalClass();

// Nje inicjalizim i nje klase anonime behet duke implementuar nje klas
//        abstrake e te gjitha metodat e saj abstracte si me posht
//        Car v1 = new Car("sedan","red") {
//            public static final String version = "new version";
//            @Override
//            protected void runEngine() {
//                System.out.printf("Anonymous car object with color: %s is running\n", getColor());
//            }
//        } ;

//        v1.runEngine();

        String fuelType = m1.getFuelType();

        System.out.println("m1 object fuel type is " + fuelType);

    }
}
