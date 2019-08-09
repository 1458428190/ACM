package com.gdufe.leetcode;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/7/26 20:52
 */
public class LeetCode24 {

    public static void main(String[] args) {
        LeetCode24 leetCode24 = new LeetCode24();
        ListNode test1 = new ListNode(1);
        ListNode head = test1;
        for (int i = 2; i <= 8; i++) {
            test1.next = new ListNode(i);
            test1 = test1.next;
        }
        System.out.println(leetCode24.swapPairs(head));
    }

    /**
     * 每次记录4个指针
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        int index = 0;
        ListNode temp = head, l2 = null, nHead = null;
        ListNode[] ln = new ListNode[4];
        while (null != temp) {
            ln[index++] = temp;
            temp = temp.next;
            // 4个为一轮
            if (index == 4) {
                index = 0;
                // 清空
                for (int i = 0; i < 4; i++) {
                    ln[i].next = null;
                }
                // 拼接
                ln[1].next = ln[0];
                ln[0].next = ln[3];
                ln[3].next = ln[2];
                // 接上上一轮的尾
                if (null != l2) {
                    l2.next = ln[1];
                }
                l2 = ln[2];
                // 标记新的头
                if (null == nHead) {
                    nHead = ln[1];
                }
            }
        }

        // 处理不足一轮的
        // 清空
        for (int i = 0; i < index; i++) {
            ln[i].next = null;
        }
        // 拼接剩余的
        if (index > 0) {
            // 还能凑对
            if (index > 1) {
                ln[1].next = ln[0];
                if (null != l2) {
                    l2.next = ln[1];
                } else {
                    // 之前不足一轮
                    nHead = ln[1];
                }
                // 处理第3第4
                if(index > 3) {
                    ln[0].next = ln[3];
                    ln[3].next = ln[2];
                } else if(index > 2) {
                    ln[0].next = ln[2];
                }
            }
            // 不能凑对
            else {
                if (null != l2) {
                    l2.next = ln[0];
                } else {
                    nHead = ln[0];
                }
            }
        }
        return nHead;
    }
}
