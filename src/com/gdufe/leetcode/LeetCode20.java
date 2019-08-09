package com.gdufe.leetcode;

import java.util.Stack;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/7/22 22:37
 */
public class LeetCode20 {
    public static void main(String[] args) {
        LeetCode20 leetCode20 = new LeetCode20();
        System.out.println(leetCode20.isValid("()"));
        System.out.println(leetCode20.isValid("()[]{}"));
        System.out.println(leetCode20.isValid("(]"));
    }

    /**
     * 执行用时 :6 ms, 在所有 Java 提交中击败了66.21%的用户
     * 内存消耗 :35.2 MB, 在所有 Java 提交中击败了82.02%的用户
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && isEqual(stack.peek(), c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    private boolean isEqual(char c1, char c2) {
        if ((c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}') || (c1 == '(' && c2 == ')')) {
            return true;
        }
        return false;
    }


}
