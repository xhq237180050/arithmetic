package com.xuhq.arithmetic.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author :
 * create at:  2021-04-23  16:04
 * @description:
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {


        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);

        //抛异常
/*        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        System.out.println(blockingQueue.element());

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());*/

        //Boolean
/*        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d"));

        System.out.println(blockingQueue.peek());

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());*/

        //阻塞
        blockingQueue.put("A");
        blockingQueue.put("B");
        blockingQueue.put("C");


        System.out.println("==========");

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());

    }
}
