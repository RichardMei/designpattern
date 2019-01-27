package com.richard.leetcode.algorithms;

import java.util.Arrays;

public class FindMedianSortedArrays {
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int[] array = new int[totalLength];
        for (int i =0; i < nums1.length; i++) {
            array[i] = nums1[i];
        }
        for (int i = nums1.length; i < totalLength; i++) {
            array[i] = nums2[i - nums1.length];
        }
        Arrays.sort(array);
        if (totalLength % 2 == 0) {
            int mid = totalLength / 2;
            return (array[mid - 1] + array[mid]) * 1.0 / 2;
        } else {
            return array[totalLength / 2 ] * 1.0;
        }
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int n1 = nums1.length;
        int n2 = nums2.length;
        int left = 0, right = n1;
        int k = (n1 + n2 + 1) / 2;

        while (left < right) {
            int m1 = left + (right - left) / 2;
            int m2 = k - m1;
            if (nums1[m1] < nums2[m2-1]) {
                left = m1 + 1;
            } else {
                right = m1;
            }
        }

        int m1 = left;
        int m2 = k - left;

        int c1 = Math.max(m1 <=0 ? Integer.MIN_VALUE : nums1[m1-1] ,
                            m2 <=0? Integer.MIN_VALUE : nums2[m2-1]);

        if ((n1 + n2) % 2 == 1) return c1;

        int c2 = Math.min(m1 >= n1? Integer.MAX_VALUE : nums1[m1],
                            m2 >= n2? Integer.MAX_VALUE : nums2[m2]);

        return (c1 + c2) * 0.5;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
