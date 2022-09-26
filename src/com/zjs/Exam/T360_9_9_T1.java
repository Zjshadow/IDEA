package com.zjs.Exam;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/9/9 16:07
 **/
public class T360_9_9_T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][2];
        int cnt = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
            if (nums[i][1] == 0) {
                ans += nums[i][0];
            }
            else {
                cnt++;
            }
        }

        int[] baoWu = new int[cnt];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i][1] == 1) {
                baoWu[idx++] = nums[i][0];
            }
        }
        Arrays.sort(baoWu);
        for (int i = baoWu.length - 1; i >= 0; i--) {
            if (ans < baoWu[i]) {
                ans += baoWu[i];
            }
            else {
                ans *= 2;
            }
        }
        System.out.println(ans);
    }
}
