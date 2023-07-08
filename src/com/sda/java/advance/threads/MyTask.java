package com.sda.java.advance.threads;

public class MyTask implements  Runnable{
    @Override
    public void run() {
        int n = 10 ;

        for(int i = 0 ; i<n ; i++){

//       Thread.currentThread()  -> return  thread number that is currently running
            System.out.println(Thread.currentThread() + "is printing: " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }
}
