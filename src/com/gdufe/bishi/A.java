package com.gdufe.bishi;

import java.util.Scanner;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/3/30 19:52
 */
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLong()) {
            long n = scanner.nextLong();
            int res = 0;
            while(n>0) {
                if(n%2!=0) {
                    res ++;
                }
                n/=2;
            }
            System.out.println(res);
        }
    }
}
