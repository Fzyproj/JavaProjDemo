package com.lucfzy.leetcode;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class ArrayWinnner1535 {
    private static int count = 0;
    public static void main(String[] args) {
        int[] arr=  {2,1,3,5,4,6,7};
        int gameWinner = findGameWinner(arr,0);
        System.out.println(gameWinner);
    }
    public static int findGameWinner(int[] arr,int index) {
        // 交换元素
        if (compareTwoNumber(arr[index],arr[++index]) == 1) {
            count++;
            int tempHead = arr[index];
            for (int i = 2; i < arr.length; i++) {
                arr[i-1] = arr[i];
            }
            arr[arr.length-1] = tempHead;
        } else {
            return count;
        }
        return findGameWinner(arr, 0);
    }

    private static int compareTwoNumber(Integer var1, Integer var2) {
        return var1.compareTo(var2);
    }
}

