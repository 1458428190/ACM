package com.gdufe.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/7/8 21:19
 */
public class LeetCode54 {
    public static void main(String[] args) {
        LeetCode54 leetCode54 = new LeetCode54();
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrix3 = {{1}, {2}};
        System.out.println(leetCode54.spiralOrder(matrix3));
    }

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了89.47%的用户
     * 内存消耗 :35.2 MB, 在所有 Java 提交中击败了42.07%的用户
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int row = 0, column = 0, rows = matrix.length - 1, columns = matrix[0].length - 1;
        while (row <= rows && column <= columns) {
            // 顺时针4个方向
            for (int j = column; j <= columns; j++) {
                list.add(matrix[row][j]);
            }
//            样例为{{1},{2}}时错误;
//            if(column != columns) {
            for (int j = row + 1; j <= rows; j++) {
                list.add(matrix[j][columns]);
            }
//            }
            if (row != rows) {
                for (int j = columns - 1; j >= column; j--) {
                    list.add(matrix[rows][j]);
                }
            }
            if (column != columns) {
                for (int j = rows - 1; j > row; j--) {
                    list.add(matrix[j][column]);
                }
            }
            column++;
            row++;
            columns--;
            rows--;
        }
        return list;
    }

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了89.47%的用户
     * 内存消耗 :34.6 MB, 在所有 Java 提交中击败了55.77%的用户
     *
     * 优化版
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) {
            return list;
        }
        int row = 0, column = 0, rows = matrix.length - 1, columns = matrix[0].length - 1;
        while (row <= rows && column <= columns) {
            // 顺时针4个方向
            for (int j = column; j <= columns; j++) {
                list.add(matrix[row][j]);
            }
            for (int j = row + 1; j <= rows; j++) {
                list.add(matrix[j][columns]);
            }
            if (row < rows && column < columns) {
                for (int j = columns - 1; j >= column; j--) {
                    list.add(matrix[rows][j]);
                }
                for (int j = rows - 1; j > row; j--) {
                    list.add(matrix[j][column]);
                }
            }
            column++;
            row++;
            columns--;
            rows--;
        }
        return list;
    }
}
