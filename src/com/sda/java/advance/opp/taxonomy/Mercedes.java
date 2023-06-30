package com.sda.java.advance.opp.taxonomy;


public class Mercedes  extends  Car implements  Vehicle{
    private String model;
    private  String engine;
    private float consume;

    private String fuelType;

    @Override
    public String getFuelType() {
        if(fuelType==null || fuelType.isEmpty()){
            return fuel;
        }

        return fuelType ;
    }


    public static class Company{
        String companyName;
        int  foundingYear;

    }

//    Inner class not static should have a method to initialize it inside the
//    outer class
    public class Owner{
        String name;
        String   surname;
        String address;

    }
    public Mercedes(String type, String color,String model, String engine, float consume ,String fuelType) {
        super(type, color);
        this.model = model;
        this.consume = consume;
        this.engine = engine;
        this.fuelType = fuelType;
    }


//abstract methods always should be overridden
    @Override
    protected void runEngine() {
        System.out.printf("Mercedes of type: %s with color: %s , consume: %.2f",super.getType(), super.getColor(), consume );
    }

    public  Owner initializeOwner(){
        return new Owner();
    }

    public static Owner initializeOwnerStatic(){
        Mercedes object =  new Mercedes(null,null,null,null,0.0f,null);
        return object.initializeOwner();
    }

}
//public class Mercedes  extends  Car implements Vehicle{
//
//    private String model;
//    private  String engine;
//
//    private float consume;
//
//    private String fuelType;
//
//
//
//
//
//
//    // Defining a nested inner class a static one
////This can be accessed just like static method like in other classes
////    public static class Company{
////        String company_name ;
////        public Company(){
////        }
////    }
//
//
////    This is public declaration of a nested class
////    This can not been accessed outside the scope of the class directly
////     like static declaration
////  public class Company {
////        String company_name ;
////        int open_year;
////    }
//
//    public Mercedes(String type , String color,  String model ,  String engine, float consume, String fuelType) {
//        super(type,color);
//        this.model = model ;
//        this.engine = engine;
//        this.consume =  consume;
//        if(fuelType==null || fuelType.isEmpty()){
//            this.fuelType = fuel ;
//        }
//    }
//
//
//
//
//    @Override
//    public String getFuelType() {
//        if(fuelType==null){
//            Vehicle.getDefaultFuel();
//            return fuel;
//        }
//        return fuelType;
//    }
//
//    @Override
//    protected void runEngine() {
//        System.out.printf("%s of model: %s with engine: %s is running\n" , Mercedes.class.getName());
//    }
//
//    @Override
//    public void changeColor(String color) {
//
//    }
//
//    public void drive(float km){
//        System.out.printf("You have consumed: %.2f L for %.2f km", calculateConsumedLiter(consume, km));
//    }
//
////    public  void workWithCompany(){
////        Company company =  new Company();
////        company.company_name = "Mercedes Benz";
////
////    }
//
//
//
//
//
//}
