package com.gdufe.pinduoduo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        sc.nextLine();
        List<List<Character>> list = new ArrayList(l);
        List<String> strs = new ArrayList();
        for(int i = 0; i < l; i++) {
            list.add(new ArrayList<Character>());
        }
        for(int i = 0; i < n; i++) {
            String str = sc.nextLine();
            strs.add(str);
            for(int j = 0; j < l; j++) {
                list.get(j).add(str.charAt(j));
            }
        }
        for (int i = 0; i < l; i++) {
            Collections.sort(list.get(i));
        }
        boolean flag = true;
        String sb = "";
        int kk = 0;
        while(flag && kk < n * l) {
            sb = "";
            int h = l;
            int k = kk;
            while(h > 0) {
                h--;
                int position = k % n;
                k /= n;
                sb = list.get(h).get(position) + sb;
            }
            kk++;
            if(!isExist(strs, sb)) {
                flag = false;
            }
        }
        if(flag) {
            System.out.println("-");
        } else {
            System.out.println(sb);
        }
    }

    private static boolean isExist(List<String> strs, String ans) {
        for(String str: strs) {
            if(ans.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
