package com.gdufe.alibaba;

import java.math.BigInteger;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2018/9/2 23:05
 */
public class test {

    public static void main(String[] args){{
        BigInteger bi = BigInteger.ONE;
        for(int i=1;i<100;i++){
            bi = bi.multiply(BigInteger.valueOf(10));
        }
        bi = bi.subtract(BigInteger.ONE);

        BigInteger sum = bi.multiply(bi).multiply(bi);
        int index=0;
        String s = String.valueOf(sum);
        char[] cs = s.toCharArray();
        System.out.println(cs);
        for(int i=0;i<cs.length;i++){
            if(cs[i]=='9'){
                index++;
            }
        }
        System.out.println(index);

    }
    }
}
