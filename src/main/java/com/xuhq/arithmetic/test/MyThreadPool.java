package com.xuhq.arithmetic.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author :
 * create at:  2021-04-25  18:14
 * @description:
 */
public class MyThreadPool {

    public static void main(String[] args) {

        ExecutorService threadPool = /*Executors.newFixedThreadPool(5); Executors.newSingleThreadExecutor();*/ Executors.newCachedThreadPool();

        try{
            for (int i = 0; i < 100; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"=======");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }


    }
}
