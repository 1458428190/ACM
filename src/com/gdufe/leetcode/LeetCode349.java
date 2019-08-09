package com.gdufe.leetcode;

import java.util.*;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/8/9 21:03
 */
public class LeetCode349 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时 :8 ms, 在所有 Java 提交中击败了80.95%的
     * 用户内存消耗 :37.1 MB, 在所有 Java 提交中击败了38.80%的用户
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        int[] result = new int[nums1.length > nums2.length ? nums2.length : nums1.length];
        int k = 0;
        for (int num : nums2) {
            if (set.contains(num)) {
                result[k++] = num;
                set.remove(num);
            }
        }
        return Arrays.copyOf(result, k);
    }
}
