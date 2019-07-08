package com.gdufe.shunfeng;

import java.util.Scanner;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2018/9/15 10:22
 */
public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int maxLength = 0;
        String ans = "";
        for(int i=4; i<s.length(); i++) {
            String res = filter(s, i+1);
            if(res!=null) {
                if(res.length() > maxLength) {
                    ans = res;
                    maxLength = res.length();
                }
            }
        }
        System.out.println(ans.equals("")?"NULL":ans);
    }

    public static String filter(String s, int length) {
        int a1 = 0, a2 = 0, a3 = 1;
        int i = length-2;
        for(; i>=0; i--) {
            if(s.charAt(i) == s.charAt(i+1)) {
                a3++;
            } else {
                break;
            }
        }
        if(i>0) {
            a2 = 1;
        }
        i--;
        for(; i>=0; i--) {
            if(s.charAt(i) == s.charAt(i+1)) {
                a2++;
            } else {
                break;
            }
        }
        if(i>0) {
            a1 = 1;
        }
        i--;
        for(; i>=0; i--) {
            if(s.charAt(i) == s.charAt(i+1)) {
                a1++;
            } else {
                break;
            }
        }

        if(a1 >= a3 && a1 > a2 && a3 != 0) {
            return s.substring(i+1, length);
        }
        else {
            return null;
        }
    }
}
