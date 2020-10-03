package com.lucfzy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class No120 {
    public static void main(String[] args) {
        // 1. 输入多个数组。
        List<Integer[]> myList = new ArrayList<>();
        myList.add(new Integer[]{2});
        myList.add(new Integer[]{3,4});
        myList.add(new Integer[]{6,5,7});
        myList.add(new Integer[]{4,8,1,3});
        myList.add(new Integer[]{4,8,5,3,4});

        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<List<Integer>> newList = new ArrayList<>();
        list.add(2);
        list1.add(3);
        list1.add(4);
        list2.add(6);
        list2.add(5);
        list2.add(7);
        list3.add(4);
        list3.add(8);
        list3.add(1);
        list3.add(3);
        newList.add(list);
        newList.add(list1);
        newList.add(list2);
        newList.add(list3);

        int i1 = minimumTotal(newList);
        System.out.println(i1);
        // 2. 给定初始化下标是0.
        int index = 0;
        // 记录总数
        int sum = 0;
        // 3. 向下递归数组。
        for (int i = 0; i < myList.size(); i++) {
            if (i == 0) {
                sum += myList.get(0)[index];
            } else {
                Integer int1 = myList.get(i)[index];
                // 不会发生数组越界异常
                Integer int2 = myList.get(i)[index+1];
                // 4. 找出在上一个数组i的位置的和i+1的位置的值，两者取最小。
                int minValue = Math.min(int1, int2);
                sum += minValue;
                if (int2 < int1) {
                    // 5. 将指针的位置进行重置。
                    // 6. 循环第3步。
                    index = index + 1;
                }
            }
        }
        System.out.println(sum);
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[n - 1][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[n - 1][i]);
        }
        return minTotal;
    }
}
