package com.gdufe.shunfeng;

import java.util.Scanner;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2018/9/15 10:24
 */
public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int maxWidth = scan.nextInt();
        String[] ss = s.split(",");
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<ss.length; i++) {
            // 单词本身超过长度
            if(ss[i].length() >= maxWidth) {
                if(sb.length() > 0 ) {
                    writeSpace(maxWidth, sb);
                    sb = new StringBuilder("");
                }
                System.out.println(ss[i]);
                continue;
            }
            String ac2333 = sb.toString().replace(" ", "")+ss[i];
            if(ac2333.length() == maxWidth) {
                System.out.println(ac2333);
                sb = new StringBuilder("");
            } else if (ac2333.length() > maxWidth) {
                writeSpace(maxWidth, sb);
                sb = new StringBuilder(ss[i]);
            } else {
                sb.append(sb.toString().equals("")?ss[i]:" "+ss[i]);
            }
        }
        System.out.println(sb.toString());
    }

    public static void writeSpace(int maxWidth, StringBuilder sb) {
        // 补空格
        int needSpaceSize = maxWidth - sb.length();
        String[] words = sb.toString().split(" ");
        needSpaceSize += words.length - 1;
        int everyWord = needSpaceSize / words.length;
        StringBuilder newSB = new StringBuilder("");
        for(int k=0; k<words.length; k++) {
            newSB.append(words[k]);
            for(int j=0; j<everyWord; j++) {
                newSB.append(" ");
            }
            if(k+1 <= needSpaceSize - everyWord * words.length) {
                newSB.append(" ");
            }
        }
        System.out.println(newSB.toString());
    }
}
