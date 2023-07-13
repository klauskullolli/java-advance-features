package com.sda.java.advance.exercises;

public class Exercise9 {

    public static void main(String[] args) {

        Circle c1  = new Circle(new Point2D(0, 0),  new Point2D(4,3) );

        System.out.printf("Radius: %.2f\n"  , c1.getRadius());
        System.out.printf("Perimeter: %.2f\n" , c1.getPerimeter());
        System.out.printf("Area: %.2f\n" , c1.getArea() );

        System.out.println("Points: " + c1.getSlicePoints());

//        Exercise 10 testing

        MoveDirection moveDirection =  new MoveDirection(1,1);

        c1.move(moveDirection);

        System.out.println("C1 " + c1);

        System.out.printf("Radius: %.2f\n"  , c1.getRadius());
        System.out.printf("Perimeter: %.2f\n" , c1.getPerimeter());
        System.out.printf("Area: %.2f\n" , c1.getArea() );


        //        Exercise 11 testing

//        Circle c2  = new Circle( new Point2D(1,1), new Point2D(5,4));


        c1.resize(2);
        System.out.printf("Radius: %.2f\n"  , c1.getRadius());
        System.out.printf("Perimeter: %.2f\n" , c1.getPerimeter());
        System.out.printf("Area: %.2f\n" , c1.getArea() );


    }
}
