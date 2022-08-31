package com.zjs.Exam;

import java.util.*;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/27 19:35
 **/
public class JD_8_27_T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < n; i = i + 2) {
            map1.put(nums[i], map1.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 1; i < n; i = i + 2) {
            map2.put(nums[i], map2.getOrDefault(nums[i], 0) + 1);
        }
        int maxNum1 = 0;
        int maxNum2 = 0;
        int min = n;

        if (n % 2 == 0) {
            maxNum1 = n/2;
            maxNum2 = maxNum1;
        }
        else {
            maxNum1 = n/2 + 1;
            maxNum2 = n /2;
        }

        for (Integer i : map1.keySet()) {
            for (Integer j : map2.keySet()) {
                if (i.equals(j)) {
                    continue;
                }
                int tmp = (maxNum1 - map1.get(i)) + maxNum2 - map2.get(j);
                min = Math.min(min, tmp);
            }
        }

        System.out.println(min);
    }
}
