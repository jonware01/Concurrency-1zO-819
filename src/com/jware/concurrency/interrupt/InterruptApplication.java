/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
