package com.gdufe.leetcode;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/7/10 21:57
 */
public class LeetCode10 {
    public static void main(String[] args) {
        LeetCode10 leetCode10 = new LeetCode10();
        System.out.println(leetCode10.isMatch("aa", "a"));
        System.out.println(leetCode10.isMatch("aa", "a*"));
        System.out.println(leetCode10.isMatch("ab", ".*"));
        System.out.println(leetCode10.isMatch("aab", "c*a*b"));
        System.out.println(leetCode10.isMatch("mississippi", "mis*is*p*."));
    }

    /**
     * 想法1：扩展*号
     * 想法2：将s转为p (如何最优化的转, KMP)
     * TODO
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {

        return false;
    }
}
