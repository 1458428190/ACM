package com.gdufe.leetcode;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/5/12 16:00
 */
public class LeetCode8 {

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("       -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("   91283472332"));
        System.out.println(myAtoi(" +1"));
        System.out.println(myAtoi("9223372036854775808"));
    }

    /**
     * 耗时：8ms
     * 内存：34.8MB
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        if (str == null || str.length() <= 0 || str.isEmpty()) {
            return 0;
        }
        long result = 0;
        boolean isFu = false;
        boolean isStart = true;
        for (int i = 0; i < str.length(); i++) {
            char val = str.charAt(i);
            if (isStart && val != '-' && val != '+' && val != ' ' && !(val >= '0' && val <= '9')) {
                return 0;
            }
            if (val == '-' && isStart) {
                isFu = true;
                isStart = false;
                continue;
            }
            if(val == '+' && isStart) {
                isStart = false;
                continue;
            }
            if (val >= '0' && val <= '9' && isStart) {
                result = val - '0';
                isStart = false;
            } else if (!isStart && val >= '0' && val <= '9') {
                result = result * 10 + val - '0';
                if(!isFu && result >= Integer.MAX_VALUE) {
                    result = Integer.MAX_VALUE;
                }
                if(isFu && result >= -(long)Integer.MIN_VALUE) {
                    result = -(long)Integer.MIN_VALUE;
                }
            } else if (!isStart) {
                break;
            }
        }
        result = isFu ? -result : result;
        if(result < Integer.MIN_VALUE) {
            result = Integer.MIN_VALUE;
        }
        if(result > Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
        }
        return (int) result;
    }
}
