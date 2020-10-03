package com.lucfzy.leetcode;

import java.sql.SQLSyntaxErrorException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class mainElement1710 {
    public static void main(String[] args) {
        // 1. new一个矩阵，行列反转。
        int[] a = {1,2,5,9,5,9,5,5,5};
        long l = System.currentTimeMillis();
        int i = majorityElement2(a);
        long l1 = System.currentTimeMillis();
        System.out.println("Time is:"+(l1-l));
        System.out.println(i);
        // 2. 对这个矩阵进行赋值。
    }

    public static int majorityElement(int[] nums) {
        // 获得nums的长度
        int length = nums.length;
        // 利用一个数组来存放每一个元素出现的次数。
        int[] temp = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (nums[i] == nums[j]) {
                    ++temp[i];
                }
            }
        }
        // 判断次数是否是大于nums的长度
        for (int i = 0; i < length; i++) {
            if (temp[i] > length / 2) {
                // 如果大于，那么返回index。
                // 返回nums[index]
                return nums[i];
            }
        }
        // 如果没有满足条件的，那么直接返回-1即可。
        return -1;
    }

    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        // 利用hashmap来实现，解决超时问题。降低时间复杂度
        Map<Integer, Integer> hashMap = new HashMap<>();
        // 保存之前检查map是否有该元素。
        for (int num : nums) {
            // 如果map已经存在了该key，那么更新value值。
            if (hashMap.containsKey(num)) {
                int value = hashMap.get(num);
                hashMap.put(num,++value);
                if (hashMap.get(num) > nums.length / 2) {
                    return num;
                }
            } else {
                // 如果map中不存在该key则，放入该key和value = 1。
                hashMap.put(num,1);
                if (hashMap.get(num) > nums.length / 2) {
                    return num;
                }
            }
        }
        return -1;
    }
}
