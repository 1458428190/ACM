package com.gdufe.test;

import java.util.Scanner;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2018/9/16 19:10
 */
public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] l = new int[n];
        int[] r = new int[n];
        for(int i=0; i<n; i++) {
            l[i] = scan.nextInt();
            r[i] = scan.nextInt();
        }
        int ans = 0;
        for (int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(l[j] < l[i] && r[j] > r[i]) {
                    ans ++;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}


