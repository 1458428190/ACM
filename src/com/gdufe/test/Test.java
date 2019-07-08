package com.gdufe.test;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/6/8 13:20
 */
public class Test {
    public static void main(String[] args) {
        String[] selects = {"Iphone X 64GB", "Iphone Xs Max 256GB"};
        System.out.println(selects[(int) System.currentTimeMillis() & 1]);
    }
}
