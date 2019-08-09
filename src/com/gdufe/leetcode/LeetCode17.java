package com.gdufe.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/7/15 20:57
 */
public class LeetCode17 {

    public static void main(String[] args) {
        LeetCode17 leetCode17 = new LeetCode17();
        System.out.println(leetCode17.letterCombinations("23"));
    }

    static String[] strs = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.94%的用户
     * 内存消耗 :35.9 MB, 在所有 Java 提交中击败了74.45%的用户
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        int len = digits.length();
        if(len <= 0) {
            return list;
        }
        for(char c: strs[digits.charAt(0) - '0' - 2].toCharArray()) {
            dfs(list, 1, "", digits, c);
        }
        return list;
    }

    public void dfs(List<String> list, int index, String s, String digits, char c) {
        s += c;
        if(index == digits.length()) {
            list.add(s);
            return;
        }
        char[] chars = strs[digits.charAt(index) - '0' - 2].toCharArray();
        for(char cItem: chars) {
            dfs(list, index+1, s, digits, cItem);
        }
    }
}
