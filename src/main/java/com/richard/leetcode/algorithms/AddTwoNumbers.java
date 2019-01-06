package com.richard.leetcode.algorithms;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    static  class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode addTwoNumbers(ListNode nodeOne, ListNode nodeTwo) {
        StringBuilder nodeOneBuilder = new StringBuilder();
        StringBuilder nodeTwoBuilder = new StringBuilder();

        ListNode pointOne = nodeOne;
        ListNode pointTwo = nodeTwo;

        do {
            nodeOneBuilder.append(pointOne.val);
            pointOne = pointOne.next;
        } while (pointOne != null);

        do {
            nodeTwoBuilder.append(pointTwo.val);
            pointTwo = pointTwo.next;
        } while (pointTwo != null);

        String one = nodeOneBuilder.toString();
        String two = nodeTwoBuilder.toString();

        StringBuilder sumBuilder = new StringBuilder();

        if (one.length() <= two.length()) {
            //进位标记
            int mark = 0;
            for (int i = 0; i < one.length(); i++) {
                int sum = Integer.parseInt(String.valueOf(one.charAt(i)))
                        + Integer.parseInt(String.valueOf(two.charAt(i))) + mark;
                if (sum >= 10) {
                    sum = sum - 10;
                    sumBuilder.append(sum);
                    mark = 1;
                } else {
                    sumBuilder.append(sum);
                    mark = 0;
                }
            }

            for (int i = one.length(); i < two.length(); i++) {
                if (mark > 0) {
                    int sum = Integer.parseInt(String.valueOf(two.charAt(i))) + mark;
                    if (sum >= 10) {
                        sum = sum - 10;
                        sumBuilder.append(sum);
                        mark = 1;
                    } else {
                        sumBuilder.append(sum);
                        mark = 0;
                    }
                }
            }

            if (mark > 0) {
                sumBuilder.append(1);
            }

        } else {
            //进位标记
            int mark = 0;
            for (int i = 0; i < two.length(); i++) {
                int sum = Integer.parseInt(String.valueOf(one.charAt(i)))
                        + Integer.parseInt(String.valueOf(two.charAt(i))) + mark;
                if (sum > 10) {
                    sum = sum - 10;
                    sumBuilder.append(sum);
                    mark = 1;
                } else {
                    sumBuilder.append(sum);
                    mark = 0;
                }
            }

            for (int i = two.length(); i < one.length(); i++) {
                if (mark > 0) {
                    int sum = Integer.parseInt(String.valueOf(one.charAt(i))) + mark;
                    if (sum > 10) {
                        sum = sum - 10;
                        sumBuilder.append(sum);
                        mark = 1;
                    } else {
                        sumBuilder.append(sum);
                        mark = 0;
                    }
                }
            }

            if (mark > 0) {
                sumBuilder.append(1);
            }

        }

        String sumString = sumBuilder.toString();

        ArrayList<ListNode> list = new ArrayList<ListNode>(sumString.length());
        for (int i = 0; i < sumString.length(); i++) {
            char c = sumString.charAt(i);
            ListNode temp = new ListNode(Integer.parseInt(String.valueOf(c)));
            list.add(temp);
        }
        for (int i = 0; i < list.size() - 1; i++){
            list.get(i).next = list.get(i + 1);
        }
        return list.get(0);
    }

    public static ListNode addTwoNumbers1(ListNode nodeOne, ListNode nodeTwo) {
        ListNode pointOne = nodeOne;
        ListNode pointTwo = nodeTwo;
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int mark = 0;

        while (pointOne != null || pointTwo != null) {
            int x = pointOne != null? pointOne.val : 0;
            int y = pointTwo != null? pointTwo.val : 0;
            int sum = x + y + mark;
            mark = sum/10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (pointOne != null) pointOne = pointOne.next;
            if (pointTwo != null) pointTwo = pointTwo.next;
        }

        if (mark > 0) curr.next = new ListNode(mark);

        return head.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(2);
        one.next = new ListNode(4);
        one.next.next = new ListNode(3);

        ListNode two = new ListNode(5);
        two.next = new ListNode(6);
        two.next.next = new ListNode(4);

        addTwoNumbers1(one, two);
    }
}
