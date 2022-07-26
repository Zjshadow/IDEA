package com.zjs.Exam;

import java.util.*;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/7/26 20:45
 **/
public class zy_7_26_T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
            }
            int[] b = new int[n];
            for (int j = 0; j < n; j++) {
                b[j] = sc.nextInt();
            }

            if (n == 1) {
                System.out.println(a[0] > b[0] ? a[0] : b[0]);
            }
            else {
                int[][] dp = new int[n + 1][2];
                dp[1][0] = a[0];
                dp[1][1] = b[0];
                dp[2][0] = a[0] + a[1];
                dp[2][1] = b[1];

                for (int j = 2; j <= n; j++) {
                    dp[j][0] = Math.max(dp[j - 1][0] + a[j - 1], dp[j - 2][1] + a[j - 1]);
                    dp[j][1] = Math.max(dp[j - 1][1] + b[j - 1], dp[j - 2][0] + b[j - 1]);
                }

                System.out.println(dp[n][0] > dp[n][1] ? dp[n][0] : dp[n][1]);
            }

        }
    }
}
