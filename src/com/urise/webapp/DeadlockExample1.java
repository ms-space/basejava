package com.urise.webapp;

public class DeadlockExample1 {
    private static final Object LOCK1 = new Object();
    private static final Object LOCK2 = new Object();

    public static void main(String[] args) {
        new DeadlockExample1().startThreads();

    }

    private void startThreads() {
        Runnable runnable1 = () -> {
            print("start");
            operation(LOCK1, LOCK2);
            print("end");
        };
        Runnable runnable2 = () -> {
            print("start");
            operation(LOCK2, LOCK1);
            print("end");
        };
        Thread thread1 = new Thread(runnable1, "T1");
        Thread thread2 = new Thread(runnable2, "T2");
        thread1.start();
        thread2.start();
        sleep(1000);
        System.out.println("Thread T1 " + thread1.getState());
        System.out.println("Thread T2 " + thread2.getState());

    }

    private void operation(Object LOCK1, Object LOCK2) {
        print("in operation() method");
        synchronized (LOCK1) {
            print("(lock on object 1) " + LOCK1);
            sleep(500);
            synchronized (LOCK2) {
                print("(lock on object 2) " + LOCK2);
            }
        }
    }

    // helper methods

    private void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void print(String s) {
        System.out.println("Thread " + Thread.currentThread().getName() + " " + s);
    }
}