package com.gdufe.jianzhioffer;

/**
 * @Author: laichengfeng
 * @Description: 数组中重复的数字，长度为n的数组，数据范围为0~n-1, 数组中某些数字是重复的，找出其中一个重复的
 * @Date: 2019/3/20 11:03
 */
public class DuplicationInArray {
    public static void main(String[] args) {
        int[] array = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(duplicate(array));
    }

    public static int duplicate(int[] num) {
        if (null == num || num.length <= 0) {
            return -1;
        }
        int length = num.length;
        for (int i = 0; i < length; i++) {
            if (num[i] < 0 || num[i] >= length) {
                return -1;
            }
        }
        for (int i = 0; i < length; i++) {
            while (num[i] != i) {
                if (num[i] == num[num[i]]) {
                    return num[i];
                }
                int temp = num[num[i]];
                num[num[i]] = num[i];
                num[i] = temp;
            }
        }
        return -1;
    }
}
