package com.gdufe.leetcode;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/7/23 21:29
 */
public class LeetCode38 {

    public static void main(String[] args) {
        LeetCode38 leetCode38 = new LeetCode38();
        System.out.println(leetCode38.countAndSay(1));
        System.out.println(leetCode38.countAndSay(4));
    }

    /**
     * 执行用时 :7 ms, 在所有 Java 提交中击败了56.86%的用户
     * 内存消耗 :36.1 MB, 在所有 Java 提交中击败了75.69%的用户
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            char ic = str.charAt(0);
            for (int j = 0; j < str.length(); j++) {
                if (ic != str.charAt(j)) {
                    sb.append(count + "" + ic);
                    count = 1;
                    ic = str.charAt(j);
                } else {
                    count++;
                }
            }
            sb.append(count + "" + ic);
            str = sb.toString();
        }
        return str;
    }
}
