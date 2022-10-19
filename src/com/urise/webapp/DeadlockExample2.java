package com.urise.webapp;

public class DeadlockExample2 {
    // waiting
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[2];
        threads[0] = new Thread(() -> {
            System.out.println("Thread 0 join thread 1");
            try {
                threads[1].join();
            } catch (InterruptedException ignore) {/*NOP*/}
        });

        threads[1] = new Thread(() -> {
            System.out.println("Thread 1 join thread 0");
            try {
                threads[0].join();
            } catch (InterruptedException ignore) {/*NOP*/}
        });

        threads[0].start();
        threads[1].start();
    }
}
