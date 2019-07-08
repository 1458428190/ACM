package com.gdufe.netease_2;

import java.util.Scanner;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2018/9/8 16:14
 */
public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i=0; i<t; i++) {
            int n = scan.nextInt();
            int k = scan.nextInt();
            int res = k <= (n + 1) / 2? k-1: n-k;
            System.out.println("0 " + res);
        }
    }
}
