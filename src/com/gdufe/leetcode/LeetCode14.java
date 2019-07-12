package com.gdufe.leetcode;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/7/12 21:58
 */
public class LeetCode14 {
    public static void main(String[] args) {
        LeetCode14 leetCode14 = new LeetCode14();
        String[] test1 = {"flower", "flow", "flight"};
        String[] test2 = {"dog", "racecar", "car"};
        System.out.println(leetCode14.longestCommonPrefix(test1));
        System.out.println(leetCode14.longestCommonPrefix(test2));
    }

    /**
     * 执行用时 :3 ms, 在所有 Java 提交中击败了63.22%的用户
     * 内存消耗 :36.1 MB, 在所有 Java 提交中击败了87.52%的用户
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len <= 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < len; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
