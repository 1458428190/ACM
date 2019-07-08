package com.gdufe.jianzhioffer;

/**
 * @Author: laichengfeng
 * @Description: 二维有序数组查找数字
 * @Date: 2019/3/20 12:20
 */
public class FindInPartiallySortedMatrix {

    public static void main(String[] args) {

    }

    public static boolean find(int[][] matrix, int rows, int columns, int number) {
        if(null == matrix || rows == 0 || columns == 0) {
            return false;
        }
        int row = 0;
        int column = columns - 1;
        while(row < rows && column >= 0) {
            if(matrix[row][column] == number) {
                return true;
            }
            if(matrix[row][column] > number) {
              column--;
            } else {
                ++row;
            }
        }
        return false;
    }

}
