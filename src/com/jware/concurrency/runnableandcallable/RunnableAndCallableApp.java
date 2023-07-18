/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jware.concurrency.runnableandcallable;

/**
 * This is a runner class that shows the difference between the <code>Runnable</code> 
 * and <code>Callable</code> interfaces.
 * <p>
 * <b>Runnable</b>
 * <ul>
 *  <li>Abstract method: <code>run</code></li>
 *  <li>Returns <code>void</code></li>
 *  <li>Cannot throw an exception</li>
 *  <li>Can run using Thread (calling thread.start)</li>
 * </ul>
 * <p>
 * <b>Callable&lt;T&gt;</b>
 * <ul>
 *  <li>Abstract method: <code>call</code></li>
 *  <li>Returns generic type T</li>
 *  <li>Can throw an exception</li>
 *  <li>Can run using ExecutorService</li>
 * </ul>
 * 
 * @author Jon Ware <jonware01@gmail.com>
 */
public class RunnableAndCallableApp {
    /**
     * Main method that kicks off the runnable and callable examples.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // A runnable thread
        Thread t = new Thread(new RunThread());
        t.start();
        
        // A runnable thread using inline code
        Thread t1 = new Thread(() -> System.out.println("In runnable method."));
        t1.start();
        
        // Callable will need ExecutorService
    }
}
