package com.gdufe.leetcode;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/5/12 14:41
 * <p>
 * <p>
 * "babcd babcd"
 * "dcbab"
 */
public class LeetCode5 {

    public static void main(String[] args) {
        System.out.println(longestPalindromeForCenter("babad"));
    }

    /**
     * 中心扩展算法
     * 耗时：16ms
     * 内存：34.7MB
     */
    public static String longestPalindromeForCenter(String s) {
        if(s.length() <= 0) {
            return s;
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > end - start) {
                start = i - ((len-1)>>1);
                end = start + len - 1;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    /**
     * DP
     * 耗时：861ms
     * 内存：375.3MB
     *
     * @param s
     * @return
     */
    public static String longestPalindromeForDp(String s) {
        int[][] dp = new int[s.length()][s.length()];
        String result = "";
        for (int length = 1; length <= s.length(); length++) {
            for (int start = 0; start <= s.length() - length; start++) {
                int end = start + length - 1;
                if (length == 1 || (s.charAt(start) == s.charAt(end) && (length == 2 || dp[start + 1][end - 1] == 1))) {
                    dp[start][end] = 1;
                    result = s.substring(start, end + 1);
                }
            }
        }
        return result;
    }

    /**
     * 暴力
     * 耗时：1226ms  n^3
     * 内存：366.1MB  1
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        String result = "";
        for (int length = 1; length <= s.length(); length++) {
            for (int start = 0; start <= s.length() - length; start++) {
                String item = s.substring(start, start + length);
                if (isHuiWen(item)) {
                    result = item;
                    break;
                }
            }
        }
        return result;
    }

    public static boolean isHuiWen(String s) {
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
