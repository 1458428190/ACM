package com.gdufe.test;

import java.util.Scanner;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2018/12/20 19:39
 */
public class F {
    public static void main(String[] args) {
        String s = "abc";
        fullPermutation(s);
    }

    private static void fullPermutation(String s) {
        permutation(s.toCharArray(), 0, s.length() - 1);

    }

    private static void permutation(char[] c, int start, int end) {
        if (start == end)
            System.out.println(new String(c));

        else {
            for (int i = start; i <= end; i++) {
                if (i != start && c[i] != c[start] || i == start) {  //防止重复
                    swap(c, i, start);
                    permutation(c, start + 1, end);    //继续深度搜索
                    swap(c, i, start);
                }
            }
        }
    }

    private static void swap(char[] c, int i, int start) {
        char temp = c[i];
        c[i] = c[start];
        c[start] = temp;
    }
}
