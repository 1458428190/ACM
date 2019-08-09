package com.gdufe.leetcode;

import java.util.Arrays;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/8/9 21:21
 */
public class LeetCode350 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时 :5 ms, 在所有 Java 提交中击败了89.16%的用户
     * 内存消耗 :36.8 MB, 在所有 Java 提交中击败了42.34%的用户
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l1 = 0, l2 = 0;
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int k = 0;
        while (l1 < nums1.length && l2 < nums2.length) {
            if (nums1[l1] == nums2[l2]) {
                result[k++] = nums1[l1];
                l1++;
                l2++;
            } else if (nums1[l1] < nums2[l2]) {
                l1++;
            } else {
                l2++;
            }
        }
        return Arrays.copyOf(result, k);
    }
}
