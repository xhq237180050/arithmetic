package com.xuhq.arithmetic.test;

import java.util.concurrent.CountDownLatch;

/**
 * @author :
 * create at:  2021-04-23  15:19
 * @description:
 */
public class CountDownLatchDemo {


    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6 ; i++) {
            final int index = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "\t 上完自习，离开教室");
                countDownLatch.countDown();
            },CountryEnum.for_counntryEnum(index).getName()).start();

        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"===========\t 班长最后离开教室");


    }
}
