/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jware.concurrency.runnableandcallable;

/**
 * This is a simple object that implements the <code>Runnable</code> interface.
 *
 * @author Jon Ware <jonware01@gmail.com>
 */
public class RunThread implements Runnable {

    /**
     * Basic method to print a message.
     *
     * @see java.lang.Runnable#run()
     *
     * @return A new <code>Object</code>
     */
    @Override
    public void run() {
        System.out.println("In runnable method.");
    }
}
