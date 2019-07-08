package com.gdufe.tengxun;

import java.util.Scanner;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2018/9/16 10:48
 */
public class C {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i=0; i<t; i++) {
            int A = scan.nextInt();
            int B = scan.nextInt();
            int C = scan.nextInt();
            boolean flag = false;
            for(int j=1; j<10000; j++) {
                if((A*j)%B == C) {
                    flag = true;
                    break;
                }
            }
            System.out.println(flag?"YES": "NO");
        }
    }
}
