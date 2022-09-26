package com.zjs.Exam;

import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/9/4 17:27
 **/
public class XHS_9_4_T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int cnt = k / n;
        int idx = k % n;

        if (cnt % 2 == 0) {
            System.out.println(nums[idx - 1]);
        }
        else {
            System.out.println(nums[n - idx]);
        }
    }
}
