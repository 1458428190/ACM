package com.gdufe.leetcode;

import java.util.Arrays;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/7/22 21:40
 */
public class LeetCode16 {
    public static void main(String[] args) {
        LeetCode16 leetCode16 = new LeetCode16();
        int[] test1 = {-1, 2, 1, -4};
        int[] test2 = {0, 0, 0, 0};
        System.out.println(leetCode16.threeSumClosest(test1, 1));
        System.out.println(leetCode16.threeSumClosest(test2, 999));
    }

    /**
     * 执行用时 :14 ms, 在所有 Java 提交中击败了71.93%的用户
     * 内存消耗 :36.3 MB, 在所有 Java 提交中击败了84.18%的用户
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            if(nums[i] > 0 && Math.abs(result) < nums[i] + nums[l] - target) {
                break;
            }
            while (l < r) {
                int value = nums[i] + nums[l] + nums[r];
                if(value == target) {
                    return target;
                }
                if(value > target) {
                    r--;
                }
                if(value < target) {
                    l++;
                }
                if (Math.abs(target - value) < Math.abs(result)) {
                    result = target - value;
                }
            }
        }
        return target - result;
    }
}
