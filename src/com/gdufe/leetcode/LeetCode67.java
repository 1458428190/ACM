package com.gdufe.leetcode;

/**
 * @Description:
 * @Author : laichengfeng
 * @Date : 2020/08/02 10:43 上午
 */
public class LeetCode67 {
    public static void main(String[] args) {

    }

    public String addBinary(String a, String b) {
        String result = "";
        int la = a.length() - 1;
        int lb = b.length() - 1;
        int jz = 0;
        while (la >= 0 || lb >= 0) {
            int va = la >= 0 ? a.charAt(la) - '0' : 0;
            int vb = lb >= 0 ? a.charAt(lb) - '0' : 0;
            char x = (char) (jz + va + vb + '0');
            if (x >= '2') {
                x = '0';
                jz = 1;
            }
            result = result + x;
            la--;
            lb--;
        }
        if (jz >= 1) {
            result = '1' + result;
        }
        return result;
    }
}
