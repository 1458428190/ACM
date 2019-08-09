package com.gdufe.leetcode;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/7/23 21:13
 */
public class LeetCode28 {
    public static void main(String[] args) {
        LeetCode28 leetCode28 = new LeetCode28();
        System.out.println(leetCode28.strStr("hello", "ll"));
        System.out.println(leetCode28.strStr("aaaaa", "bba"));
    }

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.39%的用户
     * 内存消耗 :37.3 MB, 在所有 Java 提交中击败了55.08%的用户
     * @param haystack
     * @param needle
     * @return
     */
    public int strStrTest(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * TODO 复习BF/KMP/BM/Sunday算法
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        return 0;
    }
}
