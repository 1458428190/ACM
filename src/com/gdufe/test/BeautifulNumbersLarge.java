package com.gdufe.test;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/3/28 14:09
 */
//处理大数据的
import java.util.Scanner;

public class BeautifulNumbersLarge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for(int i=1;i<=cases;i++) {
            long n = scan.nextInt();
            System.out.println("Case #"+i+":"+beautiful(n));
        }
    }

    private static long beautiful(long n) {
        for(int bits=64;bits>=2;bits--) {
            long radix = getRadix(n,bits);
            if(radix!=-1) {
                return radix;
            }
        }
        throw new IllegalArgumentException("cannot reach nums");

    }

    /**
     * 获取bits个1, 最终得到n的进制数
     * @param n
     * @param bits
     * @return
     */
    private static long getRadix(long n, int bits) {
        long minRadix = 2;
        long maxRadix = n;
        while(minRadix<maxRadix) {
            long m = minRadix+(maxRadix-minRadix)/2;
            long t = convert(m,bits);
            if(t==n) {
                return m;
            }else if(t<n) {
                minRadix = m + 1;

            }else {
                maxRadix = m;
            }
        }
        return -1;
    }

    /**
     * 计算bits个1，进制为radix  的数
     *
     * @param radix
     * @param bits
     * @return
     */
    private static long convert(long radix, int bits) {
        long component = 1;
        long sum = 0;
        for(int i=0;i<bits;i++) {
            if(Long.MAX_VALUE-sum<component) {
                sum = Long.MAX_VALUE;
            }else {

                sum +=component;
            }
            if(Long.MAX_VALUE/component<radix) {
                component = Long.MAX_VALUE;
            }else {
                component *= radix;
            }

        }
        return sum;
    }

}
