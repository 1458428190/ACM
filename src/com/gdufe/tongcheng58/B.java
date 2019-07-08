package com.gdufe.tongcheng58;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2018/9/15 20:53
 */
public class B {
    public static void main(String[] args) {
        int[] prices = new int[3];
        prices[0] = 14;
        prices[1] = 55;
        prices[2] = 39;
        System.out.println(ac(100, prices));
    }

    public static List ac(int total, int[] prices) {

        int N = prices.length;
        List<Integer> list = new ArrayList<>();
        int[] dp = new int[total + 50];
        int[][] path = new int[N + 5][total + 5];
        for (int i = 1; i <= N; i++) {
            for (int j = prices[i-1]; j <= total; j++) {
                path[i][j] = 0;
                if (dp[j] < dp[j - prices[i-1]] + prices[i-1]) {
                    dp[j] = dp[j - prices[i-1]] + prices[i-1];
                    path[i][j] = 1;
                }
            }
        }

        int i = N;//N个物品
        int j = total;//背包容量是V
        while (i > 0 && j > 0)
        {
            if (path[i][j] == 1)
            {
                list.add(prices[i-1]);
                j -= prices[i-1];
            }
            else               //注意此处，和第二篇的不同之处
                i--;
        }
        return list;
    }
}
