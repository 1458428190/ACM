package com.gdufe.leetcode;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/7/26 20:38
 */
public class LeetCode203 {
    public static void main(String[] args) {
        LeetCode203 leetCode203 = new LeetCode203();
        System.out.println(leetCode203.removeElements(null, 1));
    }

    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了92.66%的用户
     * 内存消耗 :43.6 MB, 在所有 Java 提交中击败了65.81%的用户
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        for (; head != null && head.val == val; head = head.next) ;
        ListNode ln = head;
        while (ln != null && ln.next != null) {
            if (ln.next.val == val) {
                ln.next = ln.next.next;
            } else {
                ln = ln.next;
            }
        }
        return head;
    }
}
