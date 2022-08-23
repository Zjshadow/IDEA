package com.zjs.Exam;


import java.util.Arrays;
import java.util.Scanner;

public class mt_8_20_T4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[] arrA = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arrB = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.abs(arrA[i - 1] + dp[i - 1][0]);
        }
        for (int i = 1; i <= m; i++) {
            dp[0][i] = Math.abs(arrB[i - 1] + dp[0][i - 1]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int left = dp[i][j - 1];
                int up = dp[i - 1][j];
                int leftUp = dp[i - 1][j - 1];
                if (arrA[i - 1] != arrB[j - 1]) {
                    int tmpA = Math.abs(arrB[j - 1] - arrA[i - 1]) + up;
                    int tmpB = Math.abs(arrA[i - 1] - arrB[j - 1]) + left;
                    int tmpC = Math.abs(arrA[i - 1] + Math.abs(arrB[j - 1])) + leftUp;
                    dp[i][j] = Math.min(tmpA, Math.min(tmpB, tmpC));
                }
                else {
                    dp[i][j] = Math.min(left, Math.min(up, leftUp));
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}
