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
 * This Object is meant to be used by calling the overridden <code>run</code>
 * method. This ensures that the resultant object runs on the thread that
 * invoked it.
 * 
 * @author Jon Ware <jonware01@gmail.com>
 */
public class RiddleThread extends Thread {
    /**
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {
        System.out.println("I'm the task of RiddleThread");
        System.out.println("The thread id in the task: " + Thread.currentThread().threadId());
    }
}