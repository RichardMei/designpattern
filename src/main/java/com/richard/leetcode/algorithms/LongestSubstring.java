package com.richard.leetcode.algorithms;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if ("".equals(s)) return 0;
        int maxLength = 1;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                char c = s.charAt(j);
                if (sb.toString().contains(String.valueOf(c))) {
                    if (sb.length() > maxLength) {
                        maxLength = sb.length();
                    }
                    break;
                } else {
                    sb.append(c);
                }
            }
            if (sb.length() > maxLength) maxLength = sb.length();
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcdeff";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
