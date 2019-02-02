package com.richard.leetcode.algorithms;

public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        if(s==null || "".equals(s)) return "";
        int len = s.length();
        String res = null;
        boolean[][] dp = new boolean[len][len];
        for (int i = len-1; i >=0 ; i--) {
            for (int j = i; j < len; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((j-i < 3) || dp[i+1][j-1]);
                if(dp[i][j] && (res == null || j-i+1 > res.length())) {
                    res = s.substring(i, j+1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcccbab";
        System.out.println(longestPalindrome(s));
    }
}
