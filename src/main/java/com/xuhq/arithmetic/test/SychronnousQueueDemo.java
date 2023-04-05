package com.xuhq.arithmetic.test;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author :
 * create at:  2021-04-23  17:50
 * @description:
 */
public class SychronnousQueueDemo {

    public static void main(String[] args){

        BlockingQueue<String> blockingQueue = new SynchronousQueue<>(false);

        new Thread(()->{
            try {

                System.out.println(Thread.currentThread().getName()+"put 1");
                blockingQueue.put("1");

                System.out.println(Thread.currentThread().getName()+"put 2");
                blockingQueue.put("2");

                System.out.println(Thread.currentThread().getName()+"put 3");
                blockingQueue.put("3");


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"take "+blockingQueue.take());

                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"take "+blockingQueue.take());

                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"take "+blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"BBB").start();

    }
}
