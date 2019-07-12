package com.gdufe.leetcode;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/7/10 21:13
 */
public class LeetCode6 {
    public static void main(String[] args) {
        LeetCode6 leetCode6 = new LeetCode6();
        System.out.println(leetCode6.convert("LEETCODEISHIRING", 3));
        System.out.println(leetCode6.convert("LEETCODEISHIRING", 4));
        System.out.println(leetCode6.convert("A", 1));
        System.out.println(leetCode6.convert("BBBBBBBBBBBB", 2));
    }

    /**
     * 找规律
     * 执行用时 :13 ms, 在所有 Java 提交中击败了83.13%的用户
     * 内存消耗 :40.4 MB, 在所有 Java 提交中击败了84.47%的用户
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int start = i;
            //true 往下走， false往上走
            boolean flag = true;
            while (start < len) {
                sb.append(s.charAt(start));
                int step = 0;
                // 处理顶底值
                if(i == 0) {
                    step = (numRows - i - 1) << 1;
                } else if(i == numRows-1) {
                    step = i<<1;
                } else {
                    step = flag ? (numRows - i - 1) << 1 : i << 1;
                    flag = !flag;
                }
                // 处理只有一行时，以及其他死循环的情况
                if(step == 0) {
                    step = 1;
                }
                start += step;
            }
        }
        return sb.toString();
    }
}
