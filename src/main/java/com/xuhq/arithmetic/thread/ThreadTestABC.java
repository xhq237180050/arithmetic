package com.xuhq.arithmetic.thread;

import java.sql.SQLOutput;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :
 * create at:  2021-04-20  10:56
 * @description:
 */
public class ThreadTestABC {


    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        new Thread(()->{
            lock.lock();
            for (int i = 0; i < 10; i++) {
                System.out.println("A");
                try {
                    conditionB.signal();
                    conditionA.await();
                } catch (InterruptedException e) {

                }
            }
            conditionB.signal();
            lock.unlock();
        }).start();

        new Thread(()->{
            lock.lock();
            for (int i = 0; i < 10; i++) {
                System.out.println("B");
                try {
                    conditionC.signal();
                    conditionB.await();
                } catch (InterruptedException e) {

                }
            }
            conditionC.signal();
            lock.unlock();
        }).start();

        new Thread(()->{
            lock.lock();
            for (int i = 0; i < 10; i++) {
                System.out.println("C");
                try {
                    conditionA.signal();
                    conditionC.await();
                } catch (InterruptedException e) {

                }
            }
            conditionA.signal();
            lock.unlock();
        }).start();
    }
}
