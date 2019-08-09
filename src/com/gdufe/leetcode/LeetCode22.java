package com.gdufe.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/7/25 20:50
 */
public class LeetCode22 {
    public static void main(String[] args) {
        LeetCode22 leetCode22 = new LeetCode22();
        for (String str : leetCode22.generateParenthesis(1)) {
            System.out.println(str);
        }
    }

    /**
     * 把(当做1,)当做-1, 排列n个1和n个-1， 保证前缀和大于等于0， 总和=0
     * 1 -1  		()
     * <p>
     * 1 -1  		()()
     * 1 1 -1 -1    (())
     * <p>
     * 1 1 1 -1 -1 -1 ((()))
     * 1 1 -1 1 -1 -1 (()())
     * 1 1 -1 -1 1 -1 (())()
     * 1 -1 1 1 -1 -1 ()(())
     * 1 -1 1 -1 1 -1 ()()()
     *
     * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :37.7 MB, 在所有 Java 提交中击败了76.02%的用户
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        char[] cs = new char[2 * n];
        cs[0] = '(';
        dfs(list, n, 1, cs, 1, 1, 0);
        return list;
    }

    /**
     * 深搜
     *
     * @param list  结果保存
     * @param n     对数
     * @param index 记录当前下标
     * @param cs    目前符号存储
     * @param sum   目前总和（保持>=0）
     * @param l     目前使用了多少个(
     * @param r     目前使用了多少个)
     */
    private void dfs(List<String> list, int n, int index, char[] cs, int sum, int l, int r) {
        // 下标已满
        if (index == 2 * n) {
            list.add(new String(cs));
            return;
        }
        // 走(
        if (l < n) {
            cs[index] = '(';
            dfs(list, n, index + 1, cs, sum + 1, l + 1, r);
        }
        // 走)， 注意要保持sum >= 0
        if (r < n && sum - 1 >= 0) {
            cs[index] = ')';
            dfs(list, n, index + 1, cs, sum - 1, l, r + 1);
        }
    }
}
