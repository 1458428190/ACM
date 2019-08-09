package com.gdufe.leetcode;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/7/23 21:02
 */
public class LeetCode26 {
    public static void main(String[] args) {
        LeetCode26 leetCode26 = new LeetCode26();
        int[] test1 = {1, 1, 2};
        int[] test2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(leetCode26.removeDuplicates(test1));
        System.out.println(leetCode26.removeDuplicates(test2));

    }

    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了94.21%的用户
     * 内存消耗 :44.5 MB, 在所有 Java 提交中击败了71.40%的用户
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
            if (nums.length <= 1) {
                return nums.length;
            }
            int position = 1;
            for (int i = 1; i < nums.length; i++) {
                if(nums[i]!=nums[i-1]) {
                    nums[position] = nums[i];
                    position++;
                }
            }
            return position;
    }
}
