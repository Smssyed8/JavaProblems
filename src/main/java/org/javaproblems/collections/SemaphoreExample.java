/** Created by Syed */
package org.javaproblems.collections;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2); // Allow 2 threads to access the resource concurrently

        Runnable worker = () -> {
            try {
                semaphore.acquire();
                System.out.println("Thread " + Thread.currentThread().getName() + " acquired the semaphore.");
                Thread.sleep(2000); // Simulate work
                System.out.println("Thread " + Thread.currentThread().getName() + " released the semaphore.");
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            } finally {
                semaphore.release();
            }
        };

        new Thread(worker).start();
        new Thread(worker).start();
        new Thread(worker).start();
        new Thread(worker).start();
        new Thread(worker).start();
    }
}

