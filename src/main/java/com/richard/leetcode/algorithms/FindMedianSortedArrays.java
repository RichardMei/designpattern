package com.richard.leetcode.algorithms;

import java.util.Arrays;

public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
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

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
