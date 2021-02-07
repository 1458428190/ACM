package com.gdufe.leetcode;

/**
 * @Description:
 * @Author : laichengfeng
 * @Date : 2020/08/02 9:11 上午
 */
public class LeetCode66 {

    public static void main(String[] args) {

    }

    public int[] plusOne(int[] digits) {
        int length = digits.length;
        digits[length - 1] += 1;
        while (digits[length - 1] >= 10) {
            digits[length - 1] -= 10;
            if (length - 1 == 0) {
                int[] result = new int[digits.length + 1];
                for (int i = 1; i <= digits.length; i++) {
                    result[i] = digits[i - 1];
                }
                result[0] = 1;
                return result;
            } else {
                length--;
                digits[length-1]+=1;
            }
        }
        return digits;
    }


}
