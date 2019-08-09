package com.gdufe.leetcode;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/7/24 20:40
 */
public class LeetCode160 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.95%的用户
     * 内存消耗 :38.3 MB, 在所有 Java 提交中击败了84.48%的用户
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int la = 0, lb = 0;
        for (ListNode listNodeA = headA; null != listNodeA; listNodeA = listNodeA.next, la++);
        for (ListNode listNodeB = headB; null != listNodeB; listNodeB = listNodeB.next, lb++);
        if(la > lb) {
            for (byte i = 0; i < la - lb; headA = headA.next, i++) ;
        } else {
            for (byte i = 0; i < lb - la; headB = headB.next, i++) ;
        }
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
