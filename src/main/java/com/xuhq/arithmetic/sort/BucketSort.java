package com.xuhq.arithmetic.sort;

import java.util.Arrays;

/**
 * @Author: xuhaiqiang
 * @Date: 2019/6/26 15:37
 * @Description: 桶排序
 */
public class BucketSort {

    /**
     * 桶排序
     *
     *
     * @param arr 排序数组
     */
    public static void bucketSort(int[] arr){
        //获取数组中的最大值
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]){
                max = arr[i];
            }
        }
        //新建一个桶
        int[] newArr = new int[max+1];
        //对桶进行初始化
        for (int i = 0; i <newArr.length ; i++) {
            newArr[i] = 0;
        }
        //对桶赋值
        for (int i = 0; i <arr.length ; i++) {
            newArr[arr[i]]++;
        }
        //对新的数组进行遍历
        int z = 0;
        //排序输出
        for (int i = 0; i < newArr.length ; i++) {
            for (int j = 0; j < newArr[i] ; j++) {
                arr[z++] = i;
            }
        }
    }

    /**
     * 测试主函数
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] arr = {23,56,78,1,5,9,900,45,789,345,2,9,63};
        //打印正常顺序的数组
        Arrays.stream(arr).boxed().forEach(integer -> System.out.print(integer+" "));
        System.out.println();
        //排序
        bucketSort(arr);
        //打印排序完的数组
        Arrays.stream(arr).boxed().forEach(integer -> System.out.print(integer+" "));
    }
}
