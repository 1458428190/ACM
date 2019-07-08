package com.gdufe.leetcode;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/5/12 14:15
 */
public class LeetCode4 {

    public static void main(String[] args) {

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int numsLength = nums1.length + nums2.length;
        int[] nums = new int[numsLength];
        int i = 0, j = 0, k = 0;
        while( i < nums1.length && j < nums2.length) {
            if(nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }
        while(i < nums1.length) {
            nums[k++] = nums1[i++];
        }
        while(j < nums2.length) {
            nums[k++] = nums2[j++];
        }
        if((numsLength&1) == 0) {
            return ((nums[(numsLength - 1)>>1] + nums[numsLength>>1]) * 1.0)/2;
        } else {
            return nums[numsLength>>1];
        }
    }

}
