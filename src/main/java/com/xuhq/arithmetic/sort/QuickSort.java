package com.xuhq.arithmetic.sort;

import java.util.Arrays;

/**
 * @Author: xuhaiqiang
 * @Date: 2019/6/25 18:23
 * @Description:快速排序
 */
public class QuickSort {

    /**
     * 快速排序算法
     * 时间复杂度 最快(NlogN) 最慢(O N2)
     * 快速排序的思想 分治思想
     * 快速排序之所比较快，因为相比冒泡排序，每次交换是跳跃式的。每次排序的时候设置一个基准点，
     * 将小于等于基准点的数全部放到基准点的左边，将大于等于基准点的数全部放到基准点的右边。
     * 这样在每次交换的时候就不会像冒泡排序一样每次只能在相邻的数之间进行交换，交换的距离就大的多了。
     * 因此总的比较和交换次数就少了，速度自然就提高了。当然在最坏的情况下，仍可能是相邻的两个数进行了交换。
     * 因此快速排序的最差时间复杂度和冒泡排序是一样的都是O(N2)，它的平均时间复杂度为O(NlogN)。其实快速排序是基于一种叫做“二分”的思想
     *
     * @param left
     * @param right
     * @param arr
     */
    public static void quickSort(int left,int right,int[] arr){

        //如果left大于right就退出
        if (left > right){
            return;
        }
        //声明变量
        int i,j,temp,t;
        //变量赋值
        i = left;
        j = right;
        //设置基元,一般数组的首个元素
        temp = arr[left];
        while (i != j){
            //顺序很重要 先从右向左
            while (arr[j] >= temp && i < j){
                j--;
            }
            //再从左向右
            while (arr[i] <= temp && i < j){
                i++;
            }
            //交换两个数在数组中的位置  当哨兵i和哨兵j没有相遇时
            if (i < j ) {
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        //终将基准数归位
        arr[left] = arr[i];
        arr[i] = temp;
        quickSort(left,i-1,arr); //继续处理左边的
        quickSort(i+1,right,arr); //继续处理右边的
    }

    /**
     * 快速排序2
     *
     * Divide：选取一个基元X（一般选取数组第一个元素），通过某种分区操作（partitioning）将数组划分为两个部分：左半部分小于等于X，右半部分大于等于X。
     * Conquer: 左右两个子数组递归地调用Divide过程。
     * Combine：快排作为就地排序算法（in place sort），不需要任何合并操作
     * 可以看出快排的核心部分就是划分过程（partitioning）,下面以一个实例来详细解释如何划分数组（图取自于《算法导论》）
     * 初始化：选取基元P，就是数组首元素。i=1,j=i+1=2 (数组下标以1开头)
     * 循环不变量：2~i之间的元素都小于或等于P，i+1~j之间的元素都大于或等于P
     * 循环过程：j从2到n，考察j位置的元素，如果大于等于P，就继续循环。如果小于P，就将j位置的元素（不应该出现在i+1~j这个区间）和i+1位置(交换之后仍在i+1~j区间)的元素交换位置，同时将i+1.这样就维持了循环不变量（见上述循环不变量说明）。直到j=n，完成最后一次循环操作。
     *
     *
     * @param left
     * @param right
     * @param arr
     */
    public static void quickSort1(int left,int right,int[] arr){
        //如果left大于right就退出
        if (left < right){
            //声明变量
            int i = left,j;
            //设置基元,一般是数组的首个元素
            int temp = arr[left];
            //思想：通过遍历筛选出大于基元的一边，和小于基元的一遍
            for (j = left+1; j <= right ; j++) {
                //凡是没有进入循环的都是大于基元的
                if (arr[j]<temp){
                    //进入基元的就和没有进入循环的进行交换
                    int t = arr[j];
                    arr[j] = arr[i+1];
                    arr[i+1] = t;
                    i++;
                }
            }
            //i是小于基元一边的最右边的,和基元进行交换,区分一遍大于基元,一边小于基元完成。
            arr[left] = arr[i];
            arr[i] = temp;
            //继续递归
            quickSort1(left,i-1,arr);
            quickSort1(i+1,right,arr);
        }
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
