package com.gdufe.leetcode;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/5/12 13:45
 */

import java.math.BigInteger;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class LeetCode2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }

    /**
     * 第一种解法，直接遍历链表
     * 耗时：11ms
     * 内存：42.9MB
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode ln = null;
        int bit = 0;
        while(l1 != null) {
            int val = bit + l1.val;
            if(l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            if(val >= 10) {
                bit = 1;
                val -= 10;
            } else {
                bit = 0;
            }
            ListNode item = new ListNode(val);
            if(result == null) {
                result = item;
            } else {
                ln.next = item;
            }
            ln = item;
            l1 = l1.next;
        }
        if(bit == 0) {
            ln.next = l2;
        } else {
            if(l2 == null) {
                ListNode item = new ListNode(bit);
                ln.next = item;
            } else {
                while(l2 != null) {
                    if(bit == 0) {
                        ln.next = l2;
                        break;
                    }
                    int val = bit + l2.val;
                    if(val >= 10) {
                        bit = 1;
                        val -= 10;
                    } else {
                        bit = 0;
                    }
                    ListNode item = new ListNode(val);
                    ln.next = item;
                    ln = item;
                    l2 = l2.next;
                }
            }
        }
        if(bit != 0) {
            ListNode item = new ListNode(bit);
            ln.next = item;
        }
        return result;
    }

    /**
     * 第二种解法，先计算结果，再写入链表
     * 耗时：44ms
     * 内存：47.4MB
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode ln = null;
        BigInteger val1 = BigInteger.ZERO;
        BigInteger val2 = BigInteger.ZERO;
        int bit = 0;
        while(l1 != null) {
            val1 = val1.add(BigInteger.valueOf(l1.val).multiply(BigInteger.valueOf(10).pow(bit)));
            bit ++;
            l1 = l1.next;
        }
        bit = 0;
        while(l2 != null) {
            val2 = val2.add(BigInteger.valueOf(l2.val).multiply(BigInteger.valueOf(10).pow(bit)));
            bit ++;
            l2 = l2.next;
        }
        BigInteger val = val1.add(val2);
        if(val.compareTo(BigInteger.ZERO) == 0) {
            return new ListNode(0);
        }
        while(val.compareTo(BigInteger.ZERO) > 0) {
            ListNode item = new ListNode(val.remainder(BigInteger.valueOf(10)).intValue());
            if(result == null) {
                result = item;
            } else {
                ln.next = item;
            }
            ln = item;
            val = val.divide(BigInteger.valueOf(10));
        }
        return result;
    }
}
