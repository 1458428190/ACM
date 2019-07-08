package com.gdufe.jinritoutiao;

import java.util.Scanner;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2018/9/9 11:02
 */
public class B {

    private final static int[][] fx = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int[][] a = new int[m][m];
        boolean[][] var = new boolean[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scan.nextInt();
                var[i][j] = false;
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1 && var[i][j] == false) {
                    dfs(a, var, i, j, m);
                    res++;
                }
            }
        }
        System.out.println(res);
    }

    private static void dfs(int[][] a, boolean[][] var, int x, int y, int m) {
        var[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int xx = x + fx[i][0];
            int yy = y + fx[i][1];
            if(valid(xx, yy, m) && !var[xx][yy] && a[xx][yy]==1) {
                dfs(a, var, xx, yy, m);
            }
        }
    }

    private static boolean valid(int x, int y, int m) {
        return 0 <= x && x < m && 0 <= y && y < m;
    }
}
