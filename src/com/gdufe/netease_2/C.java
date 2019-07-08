package com.gdufe.netease_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2018/9/8 16:38
 */
public class C {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        List<Integer> a = new ArrayList<>();
        List<Integer> water = new ArrayList<>();
        for(int i=0; i<n; i++) {
            a.add(scan.nextInt());
            water.add(0);
        }
        for(int i=0; i<m; i++) {
            int option = scan.nextInt();
            int x = 0, v = 0;
            switch (option) {
                case 1:
                    x = scan.nextInt();
                    query(water, x);
                    break;
                case 2:
                    x = scan.nextInt();
                    v = scan.nextInt();
                    fallWater(a, water, x, v);
                    break;
                default:
                    break;
            }
        }
    }
    private static void fallWater(List<Integer> a, List<Integer> water, int x, int v) {
        boolean flag = true;
        x--;
        water.set(x, water.get(x) + v);
        while(flag && x < a.size()) {
            // 溢出
            int oldV = water.get(x);
            if (oldV > a.get(x)) {
                flag = true;
                water.set(x, a.get(x));
                if(x + 1 < a.size()) {
                    water.set(x+1, water.get(x+1) + oldV - a.get(x));
                }
                x++;
            } else {
                flag = false;
            }
        }
    }

    private static void query(List<Integer> water, int x) {
        System.out.println(water.get(x-1));
    }
}
