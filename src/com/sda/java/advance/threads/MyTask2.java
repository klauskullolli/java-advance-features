package com.sda.java.advance.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyTask2 extends Thread{
    private  static Integer sum;

    private static Object lock =  new Object();

    private static Lock lock2 =  new ReentrantLock();

    public MyTask2() {
        if(sum==null){
            sum=0;
        }
    }

    @Override
    public void run() {
        int i = 5;
        for(int j=0 ; j<i; j++){
//            Each thread should share the same lock to make its analogy works fine
            synchronized (lock){
                sum++;
            }
//            Same logic as the previous block of synchronized  but using ReentrantLock
//            lock2.lock();
//            sum++;
//            lock2.unlock();

//            This is wrong as long as each initialization mean different lock
//            synchronized (this){
//                sum++;
//            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static Integer getSum() {
        return sum;
    }
}
