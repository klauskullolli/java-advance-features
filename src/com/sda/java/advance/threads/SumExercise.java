package com.sda.java.advance.threads;

import java.util.Scanner;

public class SumExercise {
    public static void main(String[] args) throws InterruptedException {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter start: ");
        int start = input.nextInt();
        int start1 = new Integer(start).intValue();
        System.out.print("Enter end: ");
        int end = input.nextInt();
        int end1 = new Integer(end).intValue();

        System.out.print("Enter thread number: ");
        int threadNr = input.nextInt();

        int nrDiff = end - start + 1;
        int nrOfSteps = nrDiff / threadNr;
        int remain = nrDiff % threadNr;

        SumCalculator sumCalculator[] = new SumCalculator[threadNr];

        for (int i = 1; i <= threadNr; i++) {
            if (i == threadNr)
                end = start + nrOfSteps + remain;
            else
                end = start + nrOfSteps;

            sumCalculator[i - 1] = new SumCalculator(start, end);
            start = end;
        }


        for (int i = 0; i < threadNr; i++) {
            sumCalculator[i].start();
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < threadNr; i++) {
            sumCalculator[i].join();
        }
        System.out.println("Sum is: " + SumCalculator.getSum());

        long endTime = System.currentTimeMillis();

        System.out.println("Elapsed time: " + (endTime - startTime));

        int sum = 0;

        startTime = System.currentTimeMillis();

        for (int i = start1; i <= end1; i++) {
            sum += i;
        }

        endTime = System.currentTimeMillis();

        System.out.println("Sum is: " + sum);

        System.out.println("Elapsed time: " + (endTime - startTime));


    }
}

