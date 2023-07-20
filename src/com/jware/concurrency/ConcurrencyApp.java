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

package com.jware.concurrency;

/**
 * This is the runner class for Concurrency Application examples. This will kick
 * off a number of simple thread examples to show how threading in different
 * scenarios works.
 * 
 * @author Jon Ware <jonware01@gmail.com>
 */
public class ConcurrencyApp {

    /**
     * This is the main thread that kicks off the Thread Examples.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // This thread overrides the Thread class directly and invokes the start method.
        // Result: A child thread is created and executes in the order that
        // each thread is run (results will change).
        Thread thread = new Thread(() -> System.out.println("Runnable: " + Thread.currentThread().threadId()));
        thread.start();
        System.out.println("Main: " + Thread.currentThread().threadId());
        
        // This thread implements a custom Thread class which overrides the run method.
        // Result: A child thread is created and exexutes in the order that
        // each thread is run (results will change).
        CustomThread customThread = new CustomThread();
        customThread.start();
        
        // This thread implements a custom Thread class which overrides the run method.
        // Result: A child thread is not created as the run method is invoked directly.
        // The result will be in-order of programming.
        RiddleThread riddleThread = new RiddleThread();
        // Note: The run method is called directly
        riddleThread.run();
        System.out.println("The thread id in main is: " + Thread.currentThread().threadId());
    }   
}