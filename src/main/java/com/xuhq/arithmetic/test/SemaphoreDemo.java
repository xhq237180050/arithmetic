package com.xuhq.arithmetic.test;

import java.util.concurrent.Semaphore;

/**
 * @author :
 * create at:  2021-04-23  15:56
 * @description:
 */
public class SemaphoreDemo {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {

            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t 抢到车位");
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName()+"\t 停车3秒后离开");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
