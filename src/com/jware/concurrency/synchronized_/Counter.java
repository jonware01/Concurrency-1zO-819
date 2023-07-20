/*
 * MIT License
 * 
 * Copyright (c) 2019 Allan Im
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.jware.concurrency.synchronized_;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is the runner class for Concurrency Application examples. This will kick
 * off a number of examples for synchronized blocks of code.
 * 
 * Limitations of <code>synchronized</code> keyword in code:
 * <ul>
 * <li>Threads are waiting</li>
 * <li>No way to check if a lock is available</li>
 * <li>If lock remains, it results in a deadlock</li>
 * </ul>
 * <p>
 * Using a <code>{@link java.util.concurrent.locks.Lock}</code> provides a
 * set of additional methods that allow finer granularity of locking:<br/>
 * <code>lock()</code> and <code>unlock()</code>
 * <p>
 * Waiting for a specified amount of time for a lock:<br/>
 * <code>tryLock(TimeUnit)</code>
 * <p>
 * Or trying to lock but continuing in the case a lock cannot be obtained:<br/>
 * <code>tryLock()</code>
 * 
 * @author Jon Ware <jonware01@gmail.com>
 */
public class Counter {
    public static int counter = 0;
    public static Object objectLock = new Object();
    // Reentrant Locks use FIFO on waiting threads
    public static Lock reentrantLock = new ReentrantLock();
    
    /**
     * This is a purposefully non-synchronized method to increment the counter
     */
    public static void incrementCounter() {
        int current = counter;
        System.out.println("Before: " + counter + ", Thread Id: " + Thread.currentThread().threadId());
        counter = current + 1;
        System.out.println("After: " + counter + ", Thread Id: " + Thread.currentThread().threadId());
    }
    
    /**
     * This is a synchronized method, which has been synchronized at the method
     * declaration, that increments the counter using the non-synchronous
     * <code>incrementCounter</code> method.
     */
    public synchronized static void incrementCounterSynchronizedMethod() {
        incrementCounter();
    }
    
    /**
     * This is a synchronized method, which has been synchronized using an object
     * lock, that increments the counter using the non-synchronous
     * <code>incrementCounter</code> method.
     */
    public static void incrementCounterSynchronizedLock() {
        // Synchronized uses LIFO on waiting threads
        synchronized(objectLock) {
            incrementCounter();
        }
    }
    
    /**
     * This is a synchronized method, which has been synchronized using a 
     * <code>ReentrantLock</code>, that increments the counter using the 
     * non-synchronous <code>incrementCounter</code> method.
     * <p>
     * <b>Note:</b> this can fail to count to ten as we are not waiting
     * indefinitely for a lock.
     */
    public static void incrementCounterReentrantLock() {
        try {
            if(reentrantLock.tryLock(500, TimeUnit.MILLISECONDS)) {
                try {
                    incrementCounter();
                }
                finally {
                    reentrantLock.unlock();
                }
            }
            else {
                System.out.println("Thread Id: " + Thread.currentThread().threadId() + " didn't get a lock, continuing other tasks");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Counter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * This is the main thread that kicks off the Synchronized Examples.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
         * Unsynchronized threads count to ten
         */
        System.out.println("------------------------------------");
        System.out.println("Starting unsynchronized count to ten");
        System.out.println("------------------------------------");
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread incrementThread = new Thread(() -> incrementCounter());
            incrementThread.start();
            threadList.add(incrementThread);
        }
        
        // Wait for all thread execution to stop
        for(Thread incrementThread : threadList) {
            try {
                incrementThread.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Counter.class.getName()).log(Level.SEVERE, "Unsynchronized thread join interrupted", ex);
            }
        }

        // Reset
        threadList.clear();
        counter = 0;
        
        /*
         * Synchronized (by method) threads count to ten
         */
        System.out.println("----------------------------------------------");
        System.out.println("Starting synchronized (by method) count to ten");
        System.out.println("----------------------------------------------");
        for (int i = 0; i < 10; i++) {
            Thread incrementThread = new Thread(() -> incrementCounterSynchronizedMethod());
            incrementThread.start();
            threadList.add(incrementThread);
        }
        
        // Wait for all thread execution to stop
        for(Thread incrementThread : threadList) {
            try {
                incrementThread.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Counter.class.getName()).log(Level.SEVERE, "Synchronized (by method) thread join interrupted", ex);
            }
        }
        
        // Reset
        threadList.clear();
        counter = 0;
        
        /*
         * Synchronized (by object) threads count to ten
         */
        System.out.println("----------------------------------------------");
        System.out.println("Starting synchronized (by object) count to ten");
        System.out.println("----------------------------------------------");
        for (int i = 0; i < 10; i++) {
            Thread incrementThread = new Thread(() -> incrementCounterSynchronizedLock());
            incrementThread.start();
            threadList.add(incrementThread);
        }
        
        // Wait for all thread execution to stop
        for(Thread incrementThread : threadList) {
            try {
                incrementThread.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Counter.class.getName()).log(Level.SEVERE, "Synchronized (by object) thread join interrupted", ex);
            }
        }
        
        // Reset
        threadList.clear();
        counter = 0;
        
        /*
         * Synchronized (by reentrant lock) threads count to ten
         */
        System.out.println("------------------------------------------------------");
        System.out.println("Starting synchronized (by reentrant lock) count to ten");
        System.out.println("------------------------------------------------------");
        for (int i = 0; i < 10; i++) {
            Thread incrementThread = new Thread(() -> incrementCounterReentrantLock());
            incrementThread.start();
            threadList.add(incrementThread);
        }
        
        // Wait for all thread execution to stop
        for(Thread incrementThread : threadList) {
            try {
                incrementThread.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Counter.class.getName()).log(Level.SEVERE, "Synchronized (by reentrant lock) thread join interrupted", ex);
            }
        }
        
        // Reset
        threadList.clear();
        counter = 0;
    }
}
