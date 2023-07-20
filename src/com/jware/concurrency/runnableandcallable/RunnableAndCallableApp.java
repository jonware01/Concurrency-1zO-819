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
