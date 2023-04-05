package com.xuhq.arithmetic.test;

import java.util.*;

/**
 * @Author: xuhaiqiang
 * @Date: 2019/6/26 14:31
 * @Description: 测试交换
 */
public class SwapTest {

    /**
     * 测试函数
     *
     * @param args
     */
    public static void main(String[] args) {

        int a = 3 ;
        int b = 5;
        int c = a;
        a = b ;
        b = c ;
        System.out.printf("%d,%d,%d \n",a,b,c);
        //异或 :
        a = a ^ b;
        System.out.println(a);
        b = a ^ b;
        System.out.println(b);
        a = a ^ b;
        System.out.println(a);

    }
}
