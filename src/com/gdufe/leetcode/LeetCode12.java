package com.gdufe.leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/7/10 22:29
 */
public class LeetCode12 {

    public static TreeMap<Integer, String> map = new TreeMap<>();

    static {
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
    }

    public static void main(String[] args) {
        LeetCode12 leetCode12 = new LeetCode12();
//        System.out.println(leetCode12.intToRoman(3));
//        System.out.println(leetCode12.intToRoman(4));
//        System.out.println(leetCode12.intToRoman(9));
//        System.out.println(leetCode12.intToRoman(58));
//        System.out.println(leetCode12.intToRoman(1994));


        System.out.println(leetCode12.findFirstBigNumByBinarySearch(2, lomaValue));
    }

    /**
     * 执行用时 :27 ms, 在所有 Java 提交中击败了20.08%的用户
     * 内存消耗 :39.5 MB, 在所有 Java 提交中击败了91.30%的用户
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            // 可以使用二分法， 在这直接使用TreeMap
            Map.Entry<Integer, String> entry = map.floorEntry(num);
            num -= entry.getKey();
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    // 优化版
    private static int size = 13;
    private static String[] lomas = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static int[] lomaValue = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public String intToRoman2(int num) {
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
            int index = findFirstBigNumByBinarySearch(num, lomaValue);
            num -= lomaValue[index];
            sb.append(lomas[index]);
        }
        return sb.toString();
    }

    /**
     * 二分法
     * @param num
     * @param lomaValue
     * @return
     */
    private int findFirstBigNumByBinarySearch(int num, int[] lomaValue) {
        int start = 0, end = lomaValue.length - 1;
        while(start < end) {
            int mid = (start + end) >> 1;
            if(num >= lomaValue[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    /**
     * 执行用时 :22 ms, 在所有 Java 提交中击败了65.65%的用户
     * 内存消耗 :38.2 MB, 在所有 Java 提交中击败了96.92%的用户
     * @param num
     * @param lomaValue
     * @return
     */
    private int findFirstBigNum(int num, int[] lomaValue) {
        for(int i=0; i<lomaValue.length; i++) {
            if(num >= lomaValue[i]) {
                return i;
            }
        }
        return -1;
    }
}
