package com.xuhq.arithmetic.dynamicPlanning;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : xuhaiqiang
 * create at:  2020-11-20  15:23
 * @description: 动态规划
 */
public class DynamicPlanning {
    private static Map<Integer,Integer> map = new HashMap<>();
    public static int fib(int n,Map<Integer,Integer> map){
        if (n == 1 || n == 2){
            return 1;
        }
        if (map.containsKey(n)){
            return map.get(n);
        }
        int key = fib(n - 1,map) + fib(n - 2,map);
        map.put(n,key);
        return key;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(fib(40,map));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

