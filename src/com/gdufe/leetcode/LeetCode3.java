package com.gdufe.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/7/9 22:12
 */
public class LeetCode3 {
    public static void main(String[] args) {
        LeetCode3 leetCode3 = new LeetCode3();
        System.out.println(leetCode3.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(leetCode3.lengthOfLongestSubstring("bbbbb"));
        System.out.println(leetCode3.lengthOfLongestSubstring("pwwkew"));
    }

    /**
     * 用map记录每个字符上一个最近相同字符的位置，以及维护两个变量
     * 两个变量分别是最大长度和上一个到i未出现重复字符的下标
     * 每次更新maxLen和lastNoEqual
     *
     * 执行用时 :13 ms, 在所有 Java 提交中击败了84.24%的用户
     * 内存消耗 :36.9 MB, 在所有 Java 提交中击败了95.00%的用户
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        final int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0, lastNoEqual = 0;
        for (int i = 0; i < len; i++) {
            if(len - lastNoEqual <= maxLen) {
                return maxLen;
            }
            char c = s.charAt(i);
            Integer v = map.get(c);
            if (null != v && v >= lastNoEqual) {
                lastNoEqual = v + 1;
            }
            map.put(c, i);
            maxLen = Math.max(maxLen, i - lastNoEqual + 1);
        }
        return maxLen;
    }
}
