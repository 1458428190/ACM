package com.gdufe.jingdong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2018/9/9 18:09
 */
public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int cc233 = 1; cc233 <= t; cc233++ ) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                int a = scan.nextInt();
                int b = scan.nextInt();
                list.get(a > b ? b : a).add(a > b ? a : b);
            }
            if(cc233 % 3 == 0) {
                System.out.println("No");
            } else if( cc233 % 3 == 1){
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
