package com.zjs.leecode;

import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/4/17 20:20
 **/
public class wy_4_17_E_T4 {
    private static int maxValue;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }
        maxValue = rob(nums);
        System.out.println(maxValue);
    }

    public static int rob(int[][] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {            // 不能只初始化dp[0]  初始化dp[i]为只拿着当前西瓜的重量
            dp[i] = nums[i][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (j + nums[j][1] < i) {
                    // 拿当前西瓜i    之前j + nums[j][1]不能超过i  找最大的
                    dp[i] = Math.max(dp[i], dp[j] + nums[i][0]);
                }
                else {
                    // 不拿当前西瓜i
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(dp[i]);
        }
        return dp[n - 1];
    }
}
