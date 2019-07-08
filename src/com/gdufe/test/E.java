package com.gdufe.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2018/10/26 21:14
 */
public class E {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        while(scan.hasNextInt()) {
//            int a = scan.nextInt();
//            System.out.println(isDreamNum(a));
//        }
        for(int i=1; i<100; i++) {
            if(i!=14) {
                System.out.println(i + ":" + isDreamNum(i));
            }
        }
    }

    static boolean isDreamNum(int n) {
        Map<Integer, Boolean> var = new HashMap<>();
        var.put(n, true);
        while(n != 1) {
            int s = n;
            int h = 0;
            while(s > 10) {
                h += (s % 10) * (s % 10);
                s /= 10;
            }
            n = h;
            if(var.containsKey(n)) {
                break;
            }
            var.put(n, true);
        }
        if(n == 1) {
            return true;
        }
        return false;
    }
}

/*这里写解题思路
 * 通过遍历每个位数, 计算平方和, 并用map记录中间的数,
 * 如果出现重复,则说明进入死循环, 则说明不是梦想数, 否则会一直减小, 直到是个位数
 */
