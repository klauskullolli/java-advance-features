package com.sda.java.advance.exceptions;

import com.sda.java.advance.opp.taxonomy.enumExample.CustomErrorAnnotation;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*
* Exception jan classa qe kan ber extend throwable abstract class
* Each exception also has extended Exception class so each exception is subclass of Exception
* exceptions handling has 3 blocks try, catch (always after try and exception should be defined as parameter)
* and finally block that is always executed in any condition error or no error occurring
* */

@CustomErrorAnnotation(getMessage = "Hello I am a main class that handle exception", myClass = ExceptionMain.class)
public class ExceptionMain {


//    mund te krijojm nje custom exception duke ber extend nje exception tjeter
//    ne kete rast kemi ber extend Exception
    static class CustomException extends  Exception{

        private String solution;
        public CustomException(String message, String solution) {
            super(message);
            this.solution = solution;
        }

        public String getSolution() {
            return solution;
        }
    }

//    @CustomErrorAnnotation(getMessage = "Hello I am a main class that handle exception")
    public  static void useExceptionHandling(){

        int a ;
        int b;
        try {
            Scanner input =  new Scanner(System.in);
            System.out.print("Enter a: ");
            a = input.nextInt();
            System.out.print("Enter b: ");
            b = input.nextInt();
            try{
                int c =  a/b ;
                System.out.println("c value is: " + c);
            } catch (Exception e) {
                System.out.println("Division by 0 is impossible");
            }

            int d =  a*b ;

            System.out.println("d value is: " + d);

        }catch (InputMismatchException e ){
            System.out.println("You have inputted wrong data type");
//            double g =10.2;
//            System.out.printf("value of a is: %d", e);
        }catch (IndexOutOfBoundsException e ){

            System.out.println("This is IndexOutOfBoundsException Exception ");
        }catch (NullPointerException | NoSuchElementException e ){
            System.out.println("This is NullPointerException or NoSuchElementException Exception ");
        }finally {
            a = 10;
            b = 4;
            System.out.printf("By default value of a = %d and b = %d\n", a, b);
        }

    }

    public static void useExceptionHandling2(){
        int a ;
        int b;
        Scanner input =  new Scanner(System.in);
        while(true){
            try{
                System.out.print("Enter a: ");
                a = input.nextInt();
                System.out.print("Enter b: ");
                b = input.nextInt();

                if (b==0){
                    System.out.println("Division by 0 is impossible");
                    continue;
                }
                int c =  a/b ;
                System.out.println("c value is: " + c);

                int d =  a*b ;
                System.out.println("d value is: " + d);
                break;
            }catch (Exception e ){
                System.out.println();
                System.out.printf("Error message: %s\n" ,e);
                System.out.println("TRY AGAIN");
                input.next();
            }
        }
    }

    public static void exceptionThrowing() throws Exception {
        int a,b ;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a: ");
        a = input.nextInt();
        System.out.print("Enter b: ");
        b = input.nextInt();

        if(b==0){
//            throw new Exception("value b can not be 0");
            throw new CustomException("value b can not be 0", "just make value b different form 0");
//            throw new NoSuchElementException();
        }
    }

    public static void main(String[] args) {
        useExceptionHandling();
//        useExceptionHandling2();

//        try {
//            exceptionThrowing();
//        } catch (Exception e) {
//            CustomException e1 = (CustomException) e;
//            System.out.println(e1.getMessage());
//            System.out.println(e1.getSolution());
//            System.out.println(e1);
//        }
    }
}
