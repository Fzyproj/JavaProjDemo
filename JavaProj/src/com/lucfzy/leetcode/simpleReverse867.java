package com.lucfzy.leetcode;

import java.util.Arrays;

public class simpleReverse867 {
    public static void main(String[] args) {
        // 1. new一个矩阵，行列反转。
        int[][] a = {{1,2,3},{4,5,6}};
        // 2. 对这个矩阵进行赋值。
        int[][] transpose = transpose(a);
        System.out.println(Arrays.deepToString(transpose));
    }

    public static int[][] transpose(int[][] a) {
        // 构建一个n行m列的数组
        int[][] b = new int[a[0].length][a.length];
        // 遍历原数组
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                b[j][i] = a[i][j];
            }
        }
        return b;
    }
}
