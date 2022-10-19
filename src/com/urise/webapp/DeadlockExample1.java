package com.urise.webapp;

public class DeadlockExample1 {
    private static final Object LOCK1 = new Object();
    private static final Object LOCK2 = new Object();

    public static void main(String[] args) {
        DeadlockExample1 deadlock = new DeadlockExample1();
        new Thread(deadlock::operation1, "T1").start();
        new Thread(deadlock::operation2, "T2").start();
    }

    private void operation1() {
        synchronized (LOCK1) {
            print(Thread.currentThread().getName());
            sleep(500);
            operation2();
        }
    }

    private void operation2() {
        synchronized (LOCK2) {
            print(Thread.currentThread().getName());
            operation1();
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
        System.out.println(s);
    }
}