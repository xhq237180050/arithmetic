package com.xuhq.arithmetic.sort;

import java.util.Arrays;

/**
 * @Author: xuhaiqiang
 * @Date: 2019/6/25 18:23
 * @Description:快速排序
 */
public class QuickSort {

    public static void quickSort(int left,int right,int[] arr){

        int temp = arr[left];
        int i = left;
        int j = right;

        while (i <= j){
            while (arr[i] <= temp ){
                i++;
            }
            while (arr[j] >= temp){
                j--;
            }
            int temp1 = arr[i];
            arr[i] = arr[j];
            arr[j] = temp1;
        }
        arr[left] = arr[i];
        arr[i] = temp;
        quickSort(0,j-1,arr);
        quickSort(i+1,arr.length-1,arr);
    }

    /**
     * 测试主函数
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] arr = {6,1,2,7,9,3,4,5,10,8};
        //遍历数组
        Arrays.stream(arr).boxed().forEach(integer -> System.out.print(integer+" "));
        System.out.println();
        //交换
        quickSort(0,arr.length-1,arr);
        //遍历数组
        Arrays.stream(arr).boxed().forEach(integer -> System.out.print(integer+" "));
    }
}
