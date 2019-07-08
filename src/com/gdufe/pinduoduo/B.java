package com.gdufe.pinduoduo;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2018/8/30 20:41
 */

import java.util.Scanner;

public class B {

    public static void main(String[] args) {

        char[][] ch = new char[11][11];
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] strings = input.split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);
        for (int i = 0; i < n; i++) {
            String vString = scanner.nextLine();
            for(int j = 0 ;j<m;j++) {
                ch[i][j]=vString.charAt(j);
            }
        }

        for (int j = 0; j < m; ++j) {
            boolean total_wood = false;
            for (int i = 0; i < n; ++i) {
                if (ch[i][j] == 'o') {
                    total_wood = true;
                    ch[i][j] = '.';
                } else if (ch[i][j] == 'x') {
                    for (int x = i - 1; total_wood; total_wood = false, --x)
                        ch[x][j] = 'o';
                }
            }

        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j)
                System.out.print(ch[i][j]);
            System.out.print("\n");
        }

    }

}
