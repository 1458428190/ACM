package com.gdufe.leetcode;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/5/12 17:04
 *
 *  (j-i) * Math.min(ai, aj)
 */
public class LeetCode11 {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }


    public static int maxArea(int[] height) {
        int result = 0;
        for(int i=0; i<height.length-1; i++) {
            for(int j=i+1; j<height.length; j++) {
                result = Math.max(result, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return result;
    }
}
