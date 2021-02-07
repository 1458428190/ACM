package com.gdufe.leetcode;

/**
 * @Description:
 * @Author : laichengfeng
 * @Date : 2020/08/02 8:38 上午
 */
public class LeetCode58 {
    public static void main(String[] args) {
        LeetCode58 leetCode58 = new LeetCode58();
        System.out.println(leetCode58.lengthOfLastWord("Hello world"));
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int lastWorldLength = 0;
        for (int i = 0; i < s.length(); i++) {
            lastWorldLength = s.charAt(i) == ' ' ? 0 : lastWorldLength + 1;
        }
        return lastWorldLength;
    }
}
