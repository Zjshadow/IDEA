package com.zjs.Exam;

import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/13 15:58
 **/
public class mt_8_13_T5 {
    static long maxVal = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        dfs(nums, 1, 0);
        System.out.println(maxVal);
    }

    public static void dfs(int[] nums, int idx, int curVal) {
        if (idx > nums.length) {
            maxVal = Math.max(curVal, maxVal);
            return;
        }
        curVal += nums[idx - 1];
        dfs(nums, idx * 2, curVal);
        dfs(nums, idx * 2 + 1, curVal);
    }
}
