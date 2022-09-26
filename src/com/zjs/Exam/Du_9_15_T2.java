package com.zjs.Exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/9/15 18:58
 **/
public class Du_9_15_T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int[][] nums = new int[n][2];
        int max = 0;
        for (int i = 0; i < n; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
            max = Math.max(max, nums[i][1]);
        }

        int ans = 0;
        int[] hSum = new int[max + 1];
        for (int i = 0; i < n; i++) {
            for (int j = nums[i][0]; j < nums[i][1]; j++) {
                hSum[j]++;
            }
        }

        for (int i = 0; i <= max; i++) {
            if (hSum[i] >= h) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
