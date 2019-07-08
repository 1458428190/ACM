package com.gdufe.meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2018/9/6 20:46
 */
public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int t = scan.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = scan.nextInt();
        }
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i=0; i<n; i++) {
            if(map.containsKey(a[i])) {
                map.put(a[i], map.get(a[i]) + 1);
            } else {
                map.put(a[i], 1);
            }
            if(i>=k) {
                map.put(a[i-k], map.get(a[i-k])-1);
            }
            if(i>=k-1 && getMapMax(map) >= t) {
                ans ++;
            }
        }
        System.out.println(ans);
    }

    private static int getMapMax(Map<Integer, Integer> map) {
        int res = 0;
        for(int key: map.keySet()) {
            if(map.get(key) >= res) {
                res = map.get(key);
            }
        }
        return res;
    }
}
