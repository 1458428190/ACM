package com.gdufe.jinritoutiao;

import java.util.Scanner;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2018/9/9 11:38
 */
public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int res = 0;
        for (int i = 0; i < s.length()-3; i++) {
            if(isValid(Integer.parseInt(s.substring(0, i+1)))) {
                res += dfs(s, i + 1, 2);
            }
        }
        System.out.println(res);
    }

    private static int dfs(String s, int position, int ipSegment) {
        if (ipSegment == 4 && isValid(Integer.valueOf(s.substring(position)))) {
            return 1;
        } else if(ipSegment >= 4 || position>=s.length() - 1) {
            return 0;
        }
        int res = 0;
        for(int i=position; i<s.length() - (4-ipSegment); i++) {
            if(isValid(Integer.parseInt(s.substring(position, i + 1)))) {
                res += dfs(s, i+1, ipSegment + 1);
            }
        }
        return res;
    }

    private static boolean isValid(int num) {
        return num >= 0 && num <= 255;
    }
}
