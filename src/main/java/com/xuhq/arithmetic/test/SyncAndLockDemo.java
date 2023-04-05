package com.xuhq.arithmetic.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :
 * create at:  2021-04-25  15:06
 * @description:
 */
class ShareData{

    private int number = 1;

    private Lock lock = new ReentrantLock();

    private Condition c1 = lock.newCondition();

    private Condition c2 = lock.newCondition();

    private Condition c3 = lock.newCondition();


    public void print5() throws InterruptedException {

        lock.lock();
        try {
            //1判断
            while (number != 1){
                c1.await();
            }
            //2操作
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            number=2;
            //3通知
            c2.signal();
        }finally {
            lock.unlock();
        }
    }

    public void print10() throws InterruptedException {

        lock.lock();
        try {
            //1判断
            while (number != 2){
                c2.await();
            }
            //2操作
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            number=3;
            //3通知
            c3.signal();
        }finally {
            lock.unlock();
        }
    }

    public void print15() throws InterruptedException {

        lock.lock();
        try {
            //1判断
            while (number != 3){
                c3.await();
            }
            //2操作
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            number=1;
            //3通知
            c1.signal();
        }finally {
            lock.unlock();
        }
    }
}

public class SyncAndLockDemo {

    public static void main(String[] args) {
        ShareData shareDData = new ShareData();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    shareDData.print5();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AAA").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    shareDData.print10();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BBB").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    shareDData.print15();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"CCC").start();
    }


}
