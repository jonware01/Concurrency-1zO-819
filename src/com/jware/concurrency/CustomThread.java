/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jware.concurrency;

/**
 * This is a basic custom thread that writes a message to standard out. It is
 * meant to be called by invoking the <code>start</code> method so that it
 * creates a child thread for invocation.
 * 
 * @author Jon Ware <jonware01@gmail.com>
 */
public class CustomThread extends Thread {
    /**
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {
        System.out.println("I'm a custom thread");
    }
}