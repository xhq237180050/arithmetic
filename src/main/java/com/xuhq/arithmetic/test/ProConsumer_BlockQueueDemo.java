package com.xuhq.arithmetic.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author :
 * create at:  2021-04-25  15:40
 * @description:
 */
class MyResource {

    private volatile Boolean FLAG =true;

    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myprod() throws InterruptedException {

        String data = null;

        while (FLAG){
            data = atomicInteger.incrementAndGet()+"";
            boolean offer = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (offer){
                System.out.println(Thread.currentThread().getName()+"\t插入队列成功"+data);
            }else {
                System.out.println(Thread.currentThread().getName()+"\t插入队列失败"+data);
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("FLAG=false,不营业");
    }

    public void myConsumer() throws InterruptedException {

        while (FLAG){
            String result = blockingQueue.poll(2L,TimeUnit.SECONDS);
            if (result == null || result.equalsIgnoreCase("")){
                System.out.println("停止消费");
            }
            System.out.println(Thread.currentThread().getName()+"\t消费队列成功"+result);

        }

    }

    public void stop(){
        FLAG = false;
    }
}

public class ProConsumer_BlockQueueDemo {


    public static void main(String[] args) throws InterruptedException {

        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(1));

        new Thread(()->{
            try {
                myResource.myprod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"prod").start();

        new Thread(()->{
            try {
                myResource.myConsumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"consumer").start();

        TimeUnit.SECONDS.sleep(5);
        myResource.stop();
    }

}
