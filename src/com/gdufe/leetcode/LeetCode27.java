package com.gdufe.leetcode;

import java.util.Arrays;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/7/23 21:08
 */
public class LeetCode27 {
    public static void main(String[] args) {
        int[] test1 = {3, 2, 2, 3};
        int[] test2 = {0, 1, 2, 2, 3, 0, 4, 2};
        LeetCode27 leetCode27 = new LeetCode27();
        System.out.println(leetCode27.removeElement(test1, 3));
        System.out.println(Arrays.asList(test1).toArray());
        System.out.println(leetCode27.removeElement(test2, 2));
        System.out.println(Arrays.asList(test2).toArray());
    }

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了97.56%的用户
     * 内存消耗 :36.1 MB, 在所有 Java 提交中击败了84.15%的用户
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int position = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[position++] = nums[i];
            }
        }
        return position;
    }
}
