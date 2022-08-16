package com.zjs.Exam;

import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/7/31 15:51
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int maxVal = nums[0];
        int pre = nums[0];

        for (int i = 1; i < n; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            if (pre > maxVal) {
                maxVal = pre;
            }
        }

        System.out.println(maxVal);
    }
}
