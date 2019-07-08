package com.gdufe.tongcheng58;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2018/9/15 21:25
 */
public class C {
    public static void main(String[] args) {
        System.out.println(jj(7 ,6));
    }

    public static List<Integer> jj(int totalNum, int countNum) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= totalNum; i++) {
            nums.add(i);
        }
        int res = 0;
        while(nums.size()>0) {
            res += countNum - 1;
            res = res % nums.size();
            ans.add(nums.get(res));
            nums.remove(res);
        }
        return ans;
    }
}
