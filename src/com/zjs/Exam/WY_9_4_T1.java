package com.zjs.Exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/9/4 15:03
 **/
public class WY_9_4_T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        int[] res = new int[k];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            res[nums[i] % k]++;
        }

        int ans = 0;

        for (int i = 0; i < k; i++) {
            ans = Math.max(ans, res[i]);
        }
        System.out.println(ans);
    }
}