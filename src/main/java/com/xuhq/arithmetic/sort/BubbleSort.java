package com.xuhq.arithmetic.sort;

import org.springframework.util.CollectionUtils;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: xuhaiqiang
 * @Date: 2019/6/25 16:26
 * @Description: 冒泡排序
 */
public class BubbleSort {

    /**
     * 测试方法
     *
     * @param args
     */
    public static void main(String[] args) {

        int a[] = {8,100,50,22,15,6,1,1000,999,0};
        //数组转成集合
        List<Integer> list1 = CollectionUtils.arrayToList(a);
        list1.stream().forEach(integer -> System.out.print(integer+" "));
        System.out.println();
        //数组排序
        sort(a);
        //将数组遍历
        Arrays.stream(a).boxed().collect(Collectors.toList()).forEach(integer -> System.out.print(integer+" "));

    }

    /**
     * 冒泡排序方法 从大到小
     * 冒泡排序的基本思想是：每次比较两个相邻的元素，如果它们的顺序错误就把它们交换过来。
     * 时间复杂度 O(N2)
     * @param arr 排序数组
     */
    public static void sort(int[] arr){

        int temp;
        int length = arr.length-1;//数组长度
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i ; j++) {
                if (arr[j] < arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
