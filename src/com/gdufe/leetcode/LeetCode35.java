package com.gdufe.leetcode;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/7/23 21:20
 */
public class LeetCode35 {
    public static void main(String[] args) {
        LeetCode35 leetCode35 = new LeetCode35();
        int[] test1 = {1,3,5,6};
        System.out.println(leetCode35.searchInsert(test1, 5));
        System.out.println(leetCode35.searchInsert(test1, 2));
        System.out.println(leetCode35.searchInsert(test1, 7));
        System.out.println(leetCode35.searchInsert(test1, 0));
    }

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了89.99%的用户
     * 内存消耗 :37.9 MB, 在所有 Java 提交中击败了80.68%的用户
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int mid = (l + r) >> 1;
            if(target == nums[mid]) {
                return mid;
            }
            if(nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r + 1;
    }
}
