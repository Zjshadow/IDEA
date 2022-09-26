package com.zjs.Exam;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/9/4 17:27
 **/
public class XHS_9_4_T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int cnt = 0;
        int val = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            if (nums[i] < 0) {
                cnt++;
                nums[i] = - nums[i];
            }
            val = Math.min(val, Math.abs(val));
        }
        if (cnt % 2 == 1) {
            cnt = val;
        }
        else {
            cnt = 0;
        }

        int[][] dp = new int[n + 1][8];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int sumVal = 0;
        for (int i = 1; i <= n; i++) {
            sumVal += nums[i - 1] - 1;
            dp[i][1] = sumVal;
        }

        for (int j = 1; j <= 7; j++) {
            dp[1][j] = Math.abs(j - nums[0]);
        }
        int res = Math.abs(cal(dp,n,7,nums));
        System.out.println(res + 2 * cnt);
    }

    public static int cal(int[][] dp, int n, int tar, int[] nums) {
        if (dp[n][tar] != -1) {
            return dp[n][tar];
        }
        int minVal = Integer.MAX_VALUE;
        for (int i = 1; i <= tar; i++) {
            if (tar % i != 0) {
                continue;
            }
            int j = tar / i;
            minVal = Math.min(minVal, cal(dp, n - 1, j, nums)) + Math.abs(nums[n - 1] - i);
        }

        return dp[n][tar] = minVal;
    }
}
