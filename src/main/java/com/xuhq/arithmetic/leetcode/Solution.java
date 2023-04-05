package com.xuhq.arithmetic.leetcode;

/**
 * @author :
 * create at:  2021-05-13  17:36
 * @description:
 */
public class Solution {

    public static String longestPalindrome(String s) {

        int[] arr = new int[2];
        char[] chars = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int high = i, low = i;
            while (high < n - 1 && chars[i] == chars[high + 1]) {
                high++;
            }
            i = high;
            while (low - 1 >= 0 && high + 1 < n && chars[low - 1] == chars[high + 1]) {
                high++;
                low--;
            }
            if (high - low > arr[1] - arr[0]) {
                arr[0] = low;
                arr[1] = high;
            }
        }
        return s.substring(arr[0], arr[1] + 1);
    }

    public static boolean isPalindrome(int x) {

        if (x == 0) return true;
        if (x < 0 || x % 10 == 0) return false;
        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return x == reversed || x == reversed / 10;
    }

    public static void main(String[] args) {

        String s = "abcdcba";
        System.out.println(longestPalindrome(s));

        System.out.println(isPalindrome(1234));

        System.out.println(reverse(123));

        System.out.println(1L<<32);
    }

    public static int reverse(int x) {

        long n = 0;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }
        return (int)n==n? (int)n:0;
    }


}
