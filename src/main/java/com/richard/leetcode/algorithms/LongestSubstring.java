package com.richard.leetcode.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
 */
public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if ("".equals(s)) return 0;
        int maxLength = 1;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<Character>();
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                char c = s.charAt(j);
                if (set.contains(c)) {
                    if (set.size() > maxLength) {
                        maxLength = set.size();
                    }
                    break;
                } else {
                    set.add(c);
                }
            }
            if (set.size() > maxLength) maxLength = set.size();
        }

        return maxLength;
    }


    public static int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<Character>();
        int maxLength =0;
        for (int i = 0, j = 0; i < n && j < n;) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxLength = Math.max(maxLength, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128];
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabb";
        System.out.println(lengthOfLongestSubstring2(s));
    }
}
