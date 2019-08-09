package com.gdufe.leetcode;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/7/23 20:48
 */
public class LeetCode21 {
    public static void main(String[] args) {
        LeetCode21 leetCode21 = new LeetCode21();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        System.out.println(leetCode21.mergeTwoLists(l1, l2));
    }

    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了90.18%的用户
     * 内存消耗 :36.8 MB, 在所有 Java 提交中击败了85.92%的用户
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 初始一个值
        ListNode head = new ListNode(0);
        ListNode item = head;
        while (l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                item.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                item.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            item = item.next;
        }
        if(l1 != null) {
            item.next = l1;
        }
        if(l2 != null) {
            item.next = l2;
        }
        return head.next;
    }
}


