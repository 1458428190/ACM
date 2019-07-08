package com.gdufe.jingdong;

import java.util.Scanner;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2018/9/9 19:54
 */
public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
            b[i] = scan.nextInt();
            c[i] = scan.nextInt();
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(manzu(a[i], a[j], b[i], b[j], c[i], c[j])) {
                    res ++;
                    break;
                }
            }
        }
        System.out.println(res);
    }

    private static boolean manzu(int a1, int a2, int b1, int b2, int c1, int c2) {
        return a2 > a1 && b2 > b1 && c2 > c1;
    }
}
