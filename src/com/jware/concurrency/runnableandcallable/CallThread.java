/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jware.concurrency.runnableandcallable;

import java.util.concurrent.Callable;

/**
 * This is a simple object that implements the <code>Callable</code> interface
 * and returns an Object.
 *
 * @author Jon Ware <jonware01@gmail.com>
 */
public class CallThread implements Callable<Object> {

    /**
     * Basic method to return a new <code>Object</code>
     *
     * @see java.util.concurrent.Callable<Object>#call()
     * 
     * @return A new <code>Object</code>
     */
    @Override
    public Object call() {
        return new Object();
    }

}
