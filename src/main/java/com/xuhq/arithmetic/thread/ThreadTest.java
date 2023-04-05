package com.xuhq.arithmetic.thread;

/**
 * @author : 徐海强
 * create at:  2021-04-13  15:16
 * @description:
 */
public class ThreadTest extends Thread {

    @Override
    public void run() {

        synchronized (this){
            boolean b = Thread.holdsLock(this);
            System.out.println(b);
        }

    }


    public static void main(String[] args) {

        ThreadTest threadTest = new ThreadTest();
        threadTest.start();
    }
}
