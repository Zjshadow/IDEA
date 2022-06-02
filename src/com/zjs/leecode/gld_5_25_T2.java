package com.zjs.leecode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/5/25 18:52
 **/
public class gld_5_25_T2 {
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

//        Arrays.sort(nums, (a, b) -> {
//            if (a[0] == a[0]) return a[1] - b[1];
//            return a[0] - b[0];
//        });
        Arrays.sort(nums, new Comparator<int[]>() {
            public int compare(int[] num1, int[] num2) {
                return num1[0] - num2[0];
            }
        });

        int count = 0;
        int edge = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (edge <= nums[i][0]) {
                edge = nums[i][1];
            } else {
                count++;
            }
        }
        System.out.println(n - count);
    }
}
