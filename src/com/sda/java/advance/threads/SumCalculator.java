package com.sda.java.advance.threads;

public class SumCalculator extends Thread{

//    Static lock
private static Object lock =  new Object();
    //    static sum that is accessible by any thread
    private static Integer sum;

    private  Integer start;

    private Integer end;




    public SumCalculator(int start, int end){
        if(sum==null){
            sum=0;
        }
        this.start = start;
        this.end =  end;
    }

    @Override
    public void run() {
        int thSum = 0;
        for(int i=start; i<end ; i++){
           thSum +=i;
        }
        synchronized (lock){
            sum = sum + thSum;
        }
    }

    public static int getSum() {
        return sum;
    }

    public static void setSum(int sum) {
        SumCalculator.sum = sum;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
