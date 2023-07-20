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

package com.jware.concurrency.interrupt;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is the runner class for Concurrency Application examples. This will kick
 * off a number of simple thread examples to show how sleeping threads can be
 * interrupted, how interrupts should be handled, and how joins work.
 * 
 * @author Jon Ware <jonware01@gmail.com>
 */
public class InterruptApplication  {
    /**
     * Main method that kicks off the sleepy thread examples.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
         * Thread interrupt
         */
        System.out.println("--------------------------");
        System.out.println("Starting interrupt example");
        System.out.println("--------------------------");
        Thread sleepyThread = new Thread(new SleepyThread());
        sleepyThread.start();
        
        // Interrupt the thread to exit this execution early
        sleepyThread.interrupt();
        
        try {
            sleepyThread.join();
        }
        catch(InterruptedException ex) {
            Logger.getLogger(InterruptApplication.class.getName()).log(Level.SEVERE, "Join of SleepyThread was interrupted", ex);
        }
        
        /*
         * Mixed execution
         */
        System.out.println("--------------------------------");
        System.out.println("Starting mixed execution example");
        System.out.println("--------------------------------");
        Thread sleepyThread2 = new Thread(new SleepyThread());
        sleepyThread2.start();
        
        Thread sleepyThread3 = new Thread(new SleepyThread());
        sleepyThread3.start();
        
        try {
            sleepyThread2.join();
            sleepyThread3.join();
        }
        catch(InterruptedException ex) {
            Logger.getLogger(InterruptApplication.class.getName()).log(Level.SEVERE, "Join of SleepyThread 2 and 3 was interrupted", ex);
        }
        
        /*
         * Single execution of one thread at a time
         */
        System.out.println("-------------------------------------------");
        System.out.println("Starting single execution at a time example");
        System.out.println("-------------------------------------------");
        Thread sleepyThread4 = new Thread(new SleepyThread());
        sleepyThread4.start();
        
        try {
            sleepyThread4.join();
        }
        catch(InterruptedException ex) {
            Logger.getLogger(InterruptApplication.class.getName()).log(Level.SEVERE, "Join of SleepyThread 4 was interrupted", ex);
        }
        
        Thread sleepyThread5 = new Thread(new SleepyThread());
        sleepyThread5.start();
        
        try {    
            sleepyThread5.join();
        }
        catch(InterruptedException ex) {
            Logger.getLogger(InterruptApplication.class.getName()).log(Level.SEVERE, "Join of SleepyThread 4 was interrupted", ex);
        }
        
        /*
         * Delayed thread start
         */
        System.out.println("----------------------------------");
        System.out.println("Starting delayed execution example");
        System.out.println("----------------------------------");
        Thread sleepyThread6 = new Thread(new SleepyThread());
        sleepyThread6.start();
        
        try {
            sleepyThread6.join(1500);
        }
        catch(InterruptedException ex) {
            Logger.getLogger(InterruptApplication.class.getName()).log(Level.SEVERE, "Join of SleepyThread 4 was interrupted", ex);
        }
        
        Thread sleepyThread7 = new Thread(new SleepyThread());
        sleepyThread7.start();
        
        try {    
            sleepyThread7.join();
        }
        catch(InterruptedException ex) {
            Logger.getLogger(InterruptApplication.class.getName()).log(Level.SEVERE, "Join of SleepyThread 4 was interrupted", ex);
        }
    }
}
