package com.xuhq.arithmetic.structure;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : xuhaiqiang
 * create at:  2019-07-02  16:54
 * @description: 队列
 */
public class Queue {

    /**
     * 规则是这样的:首先将第 1 个数删除，紧接着将第 2 个数放到 这串数的末尾，再将第 3 个数删除并将第 4 个数放到这串数的末尾，
     * 再将第 5 个数删除...... 直到剩下最后一个数，将最后一个数也删除。按照刚才删除的顺序，把这些删除的数连在一 起就是小哈的 QQ 啦。
     * 现在你来帮帮小哼吧。小哈给小哼加密过的一串数是“6 3 1 7 5 8 9 2 4”。
     *
     */
    @Test
    public void queueTest() {

        Integer[] numArr = {6,3,1,7,5,8,9,2,4};
        List<Integer> qqList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        while (numArr.length>0){
            qqList.add(numArr[0]);
            for (int i = 2; i < numArr.length ; i++) {
                list.add(numArr[i]);
            }
            if (numArr.length > 1){
                list.add(numArr[1]);
            }
            Integer[] arr = new Integer[list.size()];
            numArr = list.toArray(arr);
            list.clear();
        }
        System.out.println(qqList);
    }

    /**
     * 上面练习题第二种解法
     *
     *
     */
    @Test
    public void queueTest1(){

        int[] qqList1 = {0,6,3,1,7,5,8,9,2,4};
        int[] qqList = new int[102];
        for (int i = 0; i < qqList1.length ; i++) {
            qqList[i] = qqList1[i];
        }
        int[] qq = new int[qqList.length-1];
        int head = 1;
        int tail = 10;
        while (head<tail){

            System.out.print(qqList[head]+",");
            head++;
            qqList[tail] = qqList[head];
            tail++;
            head++;
        }
    }
}
