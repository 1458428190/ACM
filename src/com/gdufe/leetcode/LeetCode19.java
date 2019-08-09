package com.gdufe.leetcode;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/7/24 21:48
 */
public class LeetCode19 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.76%的用户
     * 内存消耗 :35.1 MB, 在所有 Java 提交中击败了86.53%的用户
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ln = head;
        int len = 0;
        for (ListNode ln1 = head; null != ln1; ln1 = ln1.next, len++) ;
        if(len == n) {
            return head.next;
        }
        for (int i = 0; i < len - n - 1; i++) {
            ln = ln.next;
        }
        ln.next = ln.next.next;
        return head;
    }
}
