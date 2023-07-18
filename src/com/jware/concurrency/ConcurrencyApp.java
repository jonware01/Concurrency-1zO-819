/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
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