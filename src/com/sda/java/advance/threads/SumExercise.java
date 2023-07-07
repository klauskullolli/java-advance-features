package com.sda.java.advance.threads;

import java.util.Scanner;

public class SumExercise {
    public static void main(String[] args) throws InterruptedException {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter start: ");
        int start  = input.nextInt();
        System.out.print("Enter end: ");
        int end =  input.nextInt();

        System.out.print("Enter thread number: ");
        int threadNr  = input.nextInt();

        int nrDiff =  end - start + 1;
        int nrOfSteps = nrDiff/threadNr;
        int remain =  nrDiff%threadNr;

        SumCalculator sumCalculator[] =  new SumCalculator[threadNr];

        for(int i = 1; i<=threadNr; i++){
            if(i==threadNr)
                end =  start + nrOfSteps + remain;
            else
                end =  start + nrOfSteps;

            sumCalculator[i-1] = new SumCalculator(start, end);
            start = end;
        }

        for(int i = 0 ; i<threadNr ; i++){
            sumCalculator[i].start();
        }


        for(int i = 0 ; i<threadNr ; i++){
            sumCalculator[i].join();
        }
        System.out.println("Sum is: " + SumCalculator.getSum());

    }
}

