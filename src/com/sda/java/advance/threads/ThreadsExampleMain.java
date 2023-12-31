package com.sda.java.advance.threads;

import java.util.concurrent.*;

public class ThreadsExampleMain {

    public static void threadExample(){
//        To make a thread should always implement runnable in a class and then call a new thread passing this class
//        as constructor parameter
//        Also can be called as example below creating directly into constructor runnable implementation
//        Thread can be created by extending thread class
        Thread th1  =  new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<20; i++){
                    System.out.printf("Thread 1 is printing %d\n", i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread th2  =  new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.printf("Thread 2 is printing %d\n", i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
//start thread using start method
        th1.start();
        th2.start();
        try {
//            Join used to wait thread for finishing
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        System.exit(0);

        System.out.println("Threads have finished");
    }


    private static void threadExample2() {
        Thread t1 = new Thread(new MyTask());
        Thread t2 = new Thread(new MyTask());

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println(Thread.currentThread() + "is printing");
    }


    private static void threadExample3() {
        Thread t1 = new MyTask2();
        MyTask2 t2 = new MyTask2();
        System.out.println(MyTask2.getSum());
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(MyTask2.getSum());

    }

    public static void main(String[] args) {

//        threadExample();
//        threadExample2();

//        threadExample3();

        ExecutorService executor = Executors.newFixedThreadPool(2);
//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });


        int a = 23;

//        Callable interface is used in executor services that return sth after is called
//        For thread object retuning in executor service use Future objects that implement generics interface Future
//        It keeps track of parallel returning of threads (used for async programing and keep values of async operations)
        Future<Integer> fObject = executor.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                Thread.sleep(1000);
                return a + 33;
            }
        });

        try {
//            Thread.sleep(1000);
//            if (fObject.isDone()) {
//                System.out.println("Finished");
//                System.out.println(fObject.get());
//            } else {
//                System.out.println("Not finished");
//            }
//            System.exit(0);

            long startTime = System.currentTimeMillis();
            System.out.println(fObject.get());
            long endTime = System.currentTimeMillis();
            System.out.println("Elapsed time: " + (endTime - startTime));
            executor.shutdown();
            

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


    }
}
