package com.gdufe.tongcheng58;

import java.util.Scanner;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2018/9/15 20:23
 */
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i<13; i++) {
            System.out.println(share(i+1));
        }
    }
    public static int share(int child) {
        int res = 2;
        int ans = 9 - child + 1;
        for(int i=0; i<ans; i++) {
            res = res * 2 + 2;
        }
        return child >=11 ? 0 : res;
    }
}
