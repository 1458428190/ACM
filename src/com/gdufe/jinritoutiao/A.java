package com.gdufe.jinritoutiao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2018/9/9 10:47
 */
public class A {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int position = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                position = Math.max(position, map.get(ch));

            }
            res = Math.max(res, i - position);
            map.put(ch, i);
        }
        System.out.println(res);
    }
}
