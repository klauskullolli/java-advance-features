package com.sda.java.advance.threads;

//Communication
public class ThreadCommunication{

    private static Object lock = new Object();
    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("Thread 1 has acquired the lock");

                    try {
                        Thread.sleep(2000);
                        lock.wait(); //thread 1 release the lock and wait
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Thread 1 gained the lock again...");

                    lock.notify(); //notify thread 2 to continue
                }

            }
        });


        Thread t2  = new Thread(new Runnable() {
            @Override
            public void run() {
//                thread 2 gain the lock
                synchronized (lock){
                    System.out.println("Thread 2 has acquired the lock");

                    try {
                        Thread.sleep(2000);
                        lock.notify(); //after a time release the lock and pass to the other thread waiting

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    try {
                        lock.wait(); // wait again to gain lock access
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Thread 2 gained the lock again...");
                }
            }
        });

        t1.start();
        t2.start();



    }
}
