package com.xuhq.arithmetic.java8;

import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author : haiqiang
 * create at:  5/29/22  10:24 PM
 * @description:
 */
public class LambdaTest {

    public static void main(String[] args) {

    }


    /**
     * 例1、用lambda表达式实现Runnable
     */
    @Test
    public void testLambda1(){

        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("start lambda java8 first");
            }
        }).start();

        new Thread(()->System.out.println("start lambda java8 two")).start();

    }

    /**
     * 例2、使用Java 8 lambda表达式进行事件处理
     */
    @Test
    public void testLambda2(){
        JButton show =  new JButton("Show");

        show.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                System.out.println("Event handling without lambda expression is boring");

            }

        });

        show.addActionListener((e) -> {

            System.out.println("Light, Camera, Action !! Lambda expressions Rocks");

        });
    }
}
