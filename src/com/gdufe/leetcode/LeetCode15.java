package com.gdufe.leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/7/12 22:14
 */
public class LeetCode15 {
    public static void main(String[] args) {
        LeetCode15 leetCode15 = new LeetCode15();
        int[] test1 = {-1, 0, 1, 2, -1, -4};
        System.out.println(leetCode15.threeSum(test1));
    }

    /**
     * 分隔符记得不要使用 '-'
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length == 0) {
            return list;
        }
        Map<Integer, Set<String>> map = new HashMap<>();
        Map<String, Boolean> duplicationMap = new HashMap<>();
        // 先计算两数和并做去重处理
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int v = nums[i] + nums[j];
                Set<String> set = null;
                if (map.containsKey(v)) {
                    set = map.get(v);
                } else {
                    set = new HashSet<>();
                    map.put(v, set);
                }
                set.add(i + "_" + Math.min(nums[i], nums[j]) + "_" + Math.max(nums[i], nums[j]));
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(-nums[i])) {
                Set<String> strings = map.get(-nums[i]);
                for(String key: strings) {
                    // 防止重复
                    String[] keys = key.split("_");
                    int key1 = Integer.valueOf(keys[1]);
                    int key2 = Integer.valueOf(keys[2]);
                    String str = numsToString(nums[i], key1, key2);
                    if(Integer.valueOf(keys[0]) > i && !duplicationMap.containsKey(str)) {
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[i]);
                        item.add(Integer.valueOf(keys[1]));
                        item.add(Integer.valueOf(keys[2]));
                        list.add(item);
                        duplicationMap.put(str, true);
                    }
                }
            }
        }
        return list;
    }

    public String numsToString(int a, int b, int c) {
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        int mid = a + b + c - max - min;
        return max + "_" + mid + "_" + min;
    }
}
