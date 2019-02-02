package com.richard.leetcode.algorithms;

/**
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {
    public static int reverse(int x) {
        Double sum = 0.0;
        String s = String.valueOf(x);
        if (x >=0) {
            char[] src = s.toCharArray();
            for (int i = s.length()-1; i >=0 ; i--) {
                if (i == s.length() - 1 && src[i] == '0') continue;
                sum += (src[i] - '0') * Math.pow(10, i);
                if (sum > Integer.MAX_VALUE) return 0;
            }
            return sum.intValue();
        } else {
            char[] src = s.substring(1).toCharArray();
            for (int i = s.length()-2; i >=0 ; i--) {
                if (i == s.length() - 2 && src[i] == '0') continue;
                sum += (src[i] - '0') * Math.pow(10, i);
                if (sum > Integer.MAX_VALUE) return 0;
            }
            return -sum.intValue();
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(2<<31-1));
    }
}
