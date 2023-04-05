package com.xuhq.arithmetic.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :
 * create at:  2021-04-25  14:31
 * @description:
 *
 * 题目:一个初始值为0的变量,两个线程对其交替操作,一个加1,一个减1,来五轮
 * 1 线程 操作 资源类
 * 2 判断 干活 通知
 * 3 防止虚假唤醒机制
 */
class ShareDData{

    private int number = 0;

    private Lock lock = new ReentrantLock();

    private Condition conditionA = lock.newCondition();

    public void increment() throws Exception {

        lock.lock();
        try {
            while (number != 0){
                conditionA.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            conditionA.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void decrement() throws Exception {

        lock.lock();
        try {
            while (number == 0){
                conditionA.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            conditionA.signalAll();
        }finally {
            lock.unlock();
        }
    }

}

public class ProdConsumer_traditionDemo {

    public static void main(String[] args) throws Exception{

        ShareDData shareDData = new ShareDData();

        new Thread(()->{

            for (int i = 0; i < 5 ; i++) {
                try {
                    shareDData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"AAA").start();


        new Thread(()->{

            for (int i = 0; i < 5; i++) {
                try {
                    shareDData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"BBB").start();

    }

}
