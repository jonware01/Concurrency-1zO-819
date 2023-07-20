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
 * This Thread is a simple runnable that prints a message and then sleeps.
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