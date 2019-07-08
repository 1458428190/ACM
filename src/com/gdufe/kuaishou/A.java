package com.gdufe.kuaishou;

import java.util.Scanner;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2018/9/10 20:21
 */
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] sList = s.split(",");
        int n = sList.length;
        int[] a = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = Integer.valueOf(sList[i]);
        }
        int[][] dp = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = dp[i][1] = 0;
        }
        dp[n-1][0] = dp[n-1][1] = a[n-1];
        for (int i = n - 2; i >= 0; i--) {
            dp[i][0] = Math.min(a[i] + dp[i + 1][0], a[i] + dp[i + 1][1]);
            dp[i][1] = Math.min(a[i] + dp[i + 2][0], a[i] + dp[i + 2][1]);
        }
        System.out.println(Math.min(Math.min(dp[0][0], dp[0][1]), Math.min(dp[1][0], dp[1][1])));
    }
}
