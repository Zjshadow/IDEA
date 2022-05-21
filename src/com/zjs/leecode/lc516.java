package com.zjs.leecode;

import org.junit.Test;

public class lc516 {
    @Test
    public void test(){
        String s = "aaaba";
        int res = longestPalindromeSubseq(s);
        System.out.println(res);
    }


    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 0)
                        dp[i][j] = 1;
                    else if (j - i == 1)
                        dp[i][j] = 2;
                    else
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                }
                else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[0][n - 1];
    }
}
