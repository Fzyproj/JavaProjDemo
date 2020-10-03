package com.lucfzy.alpha;

public class FeiBoTest {
    public static void main(String[] args) {
        int i = f3(5);
        System.out.println(i);
    }

    public static int f3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[][] base = {{1,1},{1,0}};
        int[][] res = matrixPower(base,n-2);
        return 1*res[0][0] + 1*res[1][0];
    }

    private static int[][] matrixPower(int[][] m, int p) {
        // m.length 相当于取矩阵行的长度。
        // m[0].length 相当于是取矩阵列的长度。
        // 所以初始化的时候，先行后列。
        // 这样初始化之后，直接得到一个元素都是0的初始化数组。
        int[][] res = new int[m.length][m[0].length];
        // 对 res[0][0] res[1][1] res[2][2] ... 等这些元素进行初始化。即对角线元素都是1
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }
        int[][] tmp = m;
        // 右移后赋值。
        for ( ; p != 0; p >>= 1) {
            if ((p & 1) != 0) {
                res = multiMatrix(res,tmp);
            }
            tmp = multiMatrix(tmp,tmp);
        }
        return res;
    }

    private static int[][] multiMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        // 让两个矩阵相乘。
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }
}
