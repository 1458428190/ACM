package com.gdufe.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/7/22 21:58
 */
public class LeetCode18 {
    public static void main(String[] args) {
        LeetCode18 leetCode18 = new LeetCode18();
//        int[] test1 = {1, 0, -1, 0, -2, 2};
//        int target1 = 0;
//        System.out.println(leetCode18.fourSum(test1, target1));
//
//        int[] test2 = {-4, 0, -4, 2, 2, 2, -2, -2};
//        System.out.println(leetCode18.fourSum(test2, 7));

//        int[] test3 = {-3, -2, -1, 0, 0, 1, 2, 3};
//        System.out.println(leetCode18.fourSum(test3, 0));

        int[] test4 = {-1,2,2,-5,0,-1,4};
        System.out.println(leetCode18.fourSum(test4, 3));

        int[] test5 = {-9,4,0,-3,6,3,-3,-9,-7,1,0,-7,-8,7,1};
        System.out.println(leetCode18.fourSum(test5, -9));
    }

    /**
     * 延用三数之和的操作
     * 执行用时 :57 ms, 在所有 Java 提交中击败了71.31%的用户
     * 内存消耗 :38.7 MB, 在所有 Java 提交中击败了88.60%的用户
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        // 先固定一个数
        for (int i = 0; i < nums.length - 3; i++) {
            //防止第一个数重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            lists.addAll(threeSum(nums, i + 1, target - nums[i], nums[i]));
        }
        return lists;
    }

    private List<List<Integer>> threeSum(int[] nums, int start, int target, int val) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = start; i < nums.length - 2; i++) {
            // 防止第二个数重复
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[l] >= 0 && nums[i] + nums[l] > target) {
                    break;
                }
                int v = nums[i] + nums[l] + nums[r];
                if (v == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(val);
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    result.add(list);
                    l++;
                    r--;
                    for (; l > i + 1 && l < r && nums[l] == nums[l - 1]; l++) ;
                    for (; r < nums.length - 1 && r > l && nums[r] == nums[r + 1]; r--);
                } else if (v > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return result;
    }
}
