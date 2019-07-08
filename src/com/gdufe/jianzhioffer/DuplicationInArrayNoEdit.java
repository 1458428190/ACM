package com.gdufe.jianzhioffer;

/**
 * @Author: laichengfeng
 * @Description: 数组中重复的数字，长度为n+1的数组，数据范围为1~n, 数组中某些数字是重复的，找出其中一个重复的，不能修改原数组
 * @Date: 2019/3/20 11:31
 */
public class DuplicationInArrayNoEdit {
    public static void main(String[] args) {
        int[] array = {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(getDuplication(array));
    }

    public static int getDuplication(int[] num) {
        if (null == num || num.length<=0) {
            return -1;
        }
        int length = num.length;
        for (int i = 0; i < length; i++) {
            if(num[i] <= 0 && num[i] > length) {
                return -1;
            }
        }

        int start = 1;
        int end = length-1;
        while(end >= start) {
            int middle = (start + end) >> 1;
            int count = countRange(num, start, middle);
            if (start == end) {
                if (count > 1) {
                    return start;
                }
                return -1;
            }
            if (count > middle - start + 1) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    public static int countRange(int[] num, int start, int end) {
        if(null == num) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i <num.length; i++) {
            if (num[i] >= start && num[i] <= end) {
                count ++;
            }
        }
        return count;
    }
}
