package com.sda.java.advance.opp.taxonomy.inheritance;

public class InheritanceMain {
    static class  A {
        private String key ;
        private int value;

        public  void doSth(){
            System.out.println("I am doing sth");
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }


    }

   static class B  extends A{
        private String property ;

        public String getProperty() {
            return property;
        }

        public void setProperty(String property) {
            this.property = property;
        }
    }


    public static void main(String[] args) {
//        nje child class can not be initialized by parent class
//        nje child class mund te definohet nga nje parent class
//        B ob1  = new A();

        B obj =  new B() ;
        obj.setKey("sth");
        obj.setValue(12);
        obj.setProperty("sthElse");

        System.out.printf("obj {key: %s, value: %d, property: %s}\n", obj.getKey(),obj.getValue(), obj.getProperty());


    }
}
