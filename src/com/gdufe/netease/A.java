package com.gdufe.netease;

import java.util.Scanner;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2018/8/11 16:17
 */
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int[] a = new int[3*n];
            int[] t = new int[3*n];

            int[] sum = new int[3*n];
            int[] t_sum = new int[3*n];
            int result = 0;
            for(int i=0; i<n; i++) {
                a[i] = scanner.nextInt();
                if(i > 0)
                    sum[i] = sum[i-1] + a[i];
                else
                    sum[i] = a[i];
            }
            for(int i=0; i<n; i++) {
                t[i] = scanner.nextInt();
                if(t[i]==1) {
                    t_sum[i] = i>0?t_sum[i-1] + a[i]:a[i];
                } else {
                    t_sum[i] = i>0?t_sum[i-1]:0;
                }
            }
            for(int i=0; i<n; i++) {
                if(i + k - 1 >= n) {
                    k = n-i;
                }
                result = Math.max(result, i>0?t_sum[i-1]+(sum[i+k-1] - sum[i-1])
                    + (t_sum[n-1] - t_sum[i+k-1]) : sum[k-1]
                        + (t_sum[n-1] - t_sum[k-1]));
            }

            System.out.println(result);
        }
    }
}
