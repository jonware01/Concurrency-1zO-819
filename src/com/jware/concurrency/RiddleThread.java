/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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