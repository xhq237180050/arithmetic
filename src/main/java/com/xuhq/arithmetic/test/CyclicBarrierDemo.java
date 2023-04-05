package com.xuhq.arithmetic.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author :
 * create at:  2021-04-23  15:48
 * @description:
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("=========召唤神龙");
        });

        for (int i = 1; i <=7 ; i++) {
            final int index = i;
            new Thread(()->{
                System.out.println("收集到第"+index+"颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
