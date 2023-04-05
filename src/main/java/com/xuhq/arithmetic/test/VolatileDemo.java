package com.xuhq.arithmetic.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author :
 * create at:  2021-04-21  13:23
 * @description:
 */
public class VolatileDemo {

    public static void main(String[] args) {

        noAtomicByVolatile();

    }

    private static void noAtomicByVolatile() {
        MyData myData = new MyData();

        for (int i = 0; i < 20; i++) {

            new Thread(()->{
                for (int j = 0; j <1000; j++) {
                    myData.addPlusPlus();
                    myData.addAtomic();
                }
            },String.valueOf(i)).start();
        }

        while (Thread.activeCount()>2){
            Thread.yield();
        }

        System.out.println("finally number value:"+myData.number+"-"+myData.atomicInteger);
    }

    private static void seeOkByVolatile() {
        MyData myData = new MyData();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "come in");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println("改变后的值:"+myData.number);
        },"乐乐").start();

        while (myData.number == 0){

        }

        System.out.println("改为60了");
    }
}

class MyData {


    public volatile int number = 0;

    AtomicInteger atomicInteger = new AtomicInteger();

    public void addTo60() {

        this.number = 60;
    }

    public void addPlusPlus() {
        this.number++;
    }

    public void addAtomic() {

        this.atomicInteger.getAndIncrement();

    }
}

