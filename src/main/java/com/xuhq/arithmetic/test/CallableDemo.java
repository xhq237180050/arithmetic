package com.xuhq.arithmetic.test;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class RunThread implements Runnable{

    @Override
    public void run() {

    }
}

class CallableThread implements Callable<String>{

    @Override
    public String call() throws Exception {

        System.out.println(Thread.currentThread().getName()+"\tcome in");
        return "like";
    }
}
/**
 * @author :
 * create at:  2021-04-25  16:22
 * @description:
 */
public class CallableDemo {

    public static void main(String[] args) {

        FutureTask<String> futureTask = new FutureTask<>(new CallableThread());

        new Thread(futureTask,"AAA").start();

        try {
            String s = futureTask.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
