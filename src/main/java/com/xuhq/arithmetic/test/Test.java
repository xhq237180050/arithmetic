package com.xuhq.arithmetic.test;

/**
 * @author : xuhaiqiang
 * create at:  2021-04-13  09:40
 * @description: 面试测试类
 */
public class Test {

    public static void main(String[] args) {


        String str="hello";
        String str1="he"+ new String("llo");
        String str2 ="he" + "llo";
        String str3 = new String("hello");

        System.out.println(str == str1);
        System.out.println(str == str2);
        System.out.println(str1 == str2);
        System.out.println(str == str3);
        System.out.println(str == str3.intern());
    }
}
