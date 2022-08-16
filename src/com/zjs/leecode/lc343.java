package com.zjs.leecode;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/15 10:18
 **/
public class lc343 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(integerBreak(n));
    }
    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i/2; j++) {
                dp[i] = Math.max(dp[i], j*dp[i - j]);
            }
        }

        return dp[n];
    }
}
