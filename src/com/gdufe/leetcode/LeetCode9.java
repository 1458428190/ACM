package com.gdufe.leetcode;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/5/12 17:01
 */
public class LeetCode9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }

    /**
     * 耗时：47ms
     * 内存：35.9MB
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        String s = x + "";
        for(int i=0; i<s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length()-i-1)) {
                return false;
            }
        }
        return true;
    }
}
