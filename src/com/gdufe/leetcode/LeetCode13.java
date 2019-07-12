package com.gdufe.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/7/12 21:25
 */
public class LeetCode13 {

    public static void main(String[] args) {
        LeetCode13 leetCode13 = new LeetCode13();
        System.out.println(leetCode13.romanToInt("III"));
        System.out.println(leetCode13.romanToInt("IV"));
        System.out.println(leetCode13.romanToInt("IX"));
        System.out.println(leetCode13.romanToInt("LVIII"));
        System.out.println(leetCode13.romanToInt("MCMXCIV"));
    }

    private static int size = 13;
    private static String[] lomas = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static int[] lomaValue = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public int romanToInt(String s) {
        int result = 0;
        int len = s.length();
        int start = 0;
        while(start < len) {
            for(int i = 0; i<size; i++) {
                if(s.startsWith(lomas[i], start)) {
                    result += lomaValue[i];
                    start += lomas[i].length();
                    break;
                }
            }
        }
        return result;
    }
}
