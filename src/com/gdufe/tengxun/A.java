package com.gdufe.tengxun;

import java.util.Scanner;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2018/9/16 10:29
 */
public class A {
    private static final long[] lcm = new long[1000000+5];
    static {
        lcm[0] = 1;
        for(int i=1; i<1000000+5; i++) {
            lcm[i] = (lcm[i-1] * i)/gcd(lcm[i-1], i);
        }
    }
    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
        for(int n=1; n<1000; n++) {
            long res = 1;
            for (long m = n + 1; ; m++) {
                res = (res * m) / gcd(res, m);
                if (res % lcm[n] == 0) {
                    System.out.print("n :" +n +"  m:  "+m + "    ");
                    System.out.println("lcm[1, ... "+m+"] == "+ "lcm[ "+(n+1)+", ... " + m + "]");
//                    System.out.println(m);
                    break;
                }
            }
        }
    }

    private static long gcd(long a, long b) {
        return a % b == 0 ? b:gcd(b, a%b);
    }
}
