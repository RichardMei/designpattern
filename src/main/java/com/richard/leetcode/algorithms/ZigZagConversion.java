package com.richard.leetcode.algorithms;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        if (numRows <=1 ) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }

        int index = 0;
        while (index < s.length()) {
            for (int i = 0; i < numRows && index < s.length(); i++) {
                sb[i].append(s.charAt(index));
                index++;
            }
            for (int i = numRows-2; i > 0 && index < s.length(); i--) {
                sb[i].append(s.charAt(index));
                index++;
            }
        }

        for (int i=1; i < numRows; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 3));
    }
}
