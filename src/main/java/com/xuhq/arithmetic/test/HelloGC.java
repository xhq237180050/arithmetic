package com.xuhq.arithmetic.test;

import java.util.concurrent.TimeUnit;

/**
 * @author :
 * create at:  2021-04-26  16:23
 * @description:
 */
public class HelloGC {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("HelloGC");

        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }
}
