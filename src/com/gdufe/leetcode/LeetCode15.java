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
        int[] test2 = {-2, 0, 0, 2, 2};
        System.out.println(leetCode15.threeSum(test1));
        System.out.println(leetCode15.threeSum(test2));
    }

    /**
     * 排序 + 双指针
     * 执行用时 :98 ms, 在所有 Java 提交中击败了24.40%的用户
     * 内存消耗 :56.4 MB, 在所有 Java 提交中击败了66.53%的用户
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length <= 0) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // 如果大于0， 结束循环
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (l - 1 > i && nums[l] == nums[l - 1]) {
                    l++;
                    continue;
                }
                if (r + 1 < nums.length && nums[r] == nums[r + 1]) {
                    r--;
                    continue;
                }
                int value = nums[l] + nums[r] + nums[i];
                if (0 == value) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    result.add(list);
                    r--;
                    l++;
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                }
                if (value > 0) {
                    r--;
                } else if (value < 0) {
                    l++;
                }
            }
        }
        return result;
    }


    /**
     * 分隔符记得不要使用 '-'
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSumTest(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0) {
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
                for (String key : strings) {
                    // 防止重复
                    String[] keys = key.split("_");
                    int key1 = Integer.valueOf(keys[1]);
                    int key2 = Integer.valueOf(keys[2]);
                    String str = numsToString(nums[i], key1, key2);
                    if (Integer.valueOf(keys[0]) > i && !duplicationMap.containsKey(str)) {
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
