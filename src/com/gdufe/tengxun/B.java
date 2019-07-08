package com.gdufe.tengxun;

import java.util.*;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2018/9/16 11:27
 */
@SuppressWarnings("unchecked")
public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = 100;
        while (t-- > 0) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            Map<Integer, Set<Integer>> ruMap = new HashMap<>();
            Map<Integer, Set<Integer>> chuMap = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                ruMap.put(i, new HashSet<>());
                chuMap.put(i, new HashSet<>());
            }
            for (int i = 0; i < m; i++) {
                int u = scan.nextInt();
                int v = scan.nextInt();
                if (u == v) {
                    continue;
                }
                ruMap.get(v).add(u);
                chuMap.get(u).add(v);
            }
            int res = 0;
            for (int i = 1; i <= n; i++) {
                if (chuMap.containsKey(i)) {
                    Set<Integer> set = chuMap.get(i);
                    boolean ff = true;
                    while (ff) {
                        int ffSize = set.size();
                        Set<Integer> newSet = new HashSet<>();
                        newSet.addAll(set);
                        if(newSet.contains(i)) {
                            newSet.remove(i);
                        }
                        for (int p : newSet) {
                            if (chuMap.containsKey(p)) {
                                set.addAll(chuMap.get(p));
                            }
                        }
                        if(set.contains(i)) {
                            set.remove(i);
                        }
                        if (ffSize != set.size()) {
                            ff = true;
                        } else
                            ff = false;
                    }
                }

                if (ruMap.containsKey(i)) {
                    Set<Integer> set = ruMap.get(i);
                    boolean ff = true;
                    while (ff) {
                        int ffSize = set.size();
                        Set<Integer> newSet = new HashSet<>();
                        newSet.addAll(set);
                        if(newSet.contains(i)) {
                            newSet.remove(i);
                        }
                        for (int p : newSet) {
                            if (ruMap.containsKey(p)) {
                                set.addAll(ruMap.get(p));
                            }
                        }
                        if(set.contains(i)) {
                            set.remove(i);
                        }
                        if (ffSize != set.size()) {
                            ff = true;
                        } else
                            ff = false;
                    }
                }

                int ru = ruMap.containsKey(i) ? ruMap.get(i).size() : 0;
                int chu = chuMap.containsKey(i) ? chuMap.get(i).size() : 0;
                if (ru > chu) {
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}
