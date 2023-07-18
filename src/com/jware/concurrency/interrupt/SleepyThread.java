/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jware.concurrency.interrupt;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jon Ware <jonware01@gmail.com>
 */
public class SleepyThread implements Runnable {
    /**
     * Basic runnable method to print a message and sleep.
     *
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("Current thread id: " + Thread.currentThread().threadId() + ", iteration: " + i);
            
            try {
                Thread.sleep(500);
            } 
            // This clears the interrupted flag
            catch (InterruptedException ex) {
                Logger.getLogger(InterruptApplication.class.getName()).log(Level.SEVERE, "SleepyThread was interrupted", ex);
                
                // We are re-setting the interrupted flag to true
                Thread.currentThread().interrupt();
                
                // We must still break as we are not exiting the for loop otherwise
                // Note: if we don't break the for loop, the for loop will continue
                // to execute and the exception will be thrown every cycle of the 
                // loop when the call to sleep checks the interrupted flag.
                break;
            }
        }
    }
}