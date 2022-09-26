package com.zjs.Exam;

import java.util.*;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/9/4 15:03
 **/
public class WY_9_4_T3_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        if (n == 1) {
            System.out.println(nums[0] - k * x);
            return;
        }

        Arrays.sort(nums);
        int ans = 0;
        int[] cnt = new int[n];
        int cntSum = 0;
        for (int i = 1; i < n; i++) {
            cnt[i] = (nums[i] - nums[i - 1]) / x;
            cntSum += cnt[i];
        }

        if (k <= cntSum) {
            for (int i = n - 1; i > 0; i--) {
                if (k <= cnt[i]) {
                    ans = nums[i] - k * x;
                    System.out.println(ans);
                    break;
                }
                else {
                    k = k - cnt[i] - 1;
                }
            }
        }
        else {
            int idx = n - (k - cntSum) % n - 1;
            int cntXun = (k - cntSum) / n;
            ans = nums[idx] - cnt[idx] * x - cntXun * x;
            System.out.println(ans);
        }
    }
}
