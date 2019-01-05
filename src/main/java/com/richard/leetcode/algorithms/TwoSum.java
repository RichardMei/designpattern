package com.richard.leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

    public static int[] twoSum(int[] numbs, int target) {
        for (int i = 0; i < numbs.length; i++) {
            for (int j = i + 1; j < numbs.length; j++) {
                if (numbs[j] == target - numbs[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSumTwiceHash(int[] numbs, int target ) {
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>(numbs.length);
        for (int i = 0; i < numbs.length; i++) {
            hash.put(numbs[i], i);
        }
        for (int i = 0; i < numbs.length; i++) {
            int temp = target - numbs[i];
            if (hash.containsKey(temp) && hash.get(temp) != i) {
                return new int[] {i, hash.get(temp)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static int[] twoSumOnceHash(int[] numbs, int target ) {
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>(numbs.length);

        for (int i = 0; i < numbs.length; i++) {
            int temp = target - numbs[i];
            if (hash.containsKey(temp) && hash.get(temp) != i) {
                return new int[] {hash.get(temp), i};
            } else {
                hash.put(numbs[i], i);
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] numbs = {2, 7, 11, 15};
        int target = 18;
        int[] result = twoSumOnceHash(numbs, target);
        for (int index: result){
            System.out.println("index:" + index);
        }
    }
}
