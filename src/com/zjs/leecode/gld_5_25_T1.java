package com.zjs.leecode;

import java.util.*;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/5/25 18:52
 **/
public class gld_5_25_T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            nums[i][1] = sc.nextInt();
        }
        int ans = n - eraseOverlapIntervals(nums);
        System.out.println(ans);
    }
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == a[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int count = 0;
        int edge = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            if (edge <= intervals[i][0]) {
                edge = intervals[i][1];
            } else {
                count++;
            }
        }
        return count;
    }
}
