package com.zjs.Exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/13 15:58
 **/
public class mt_8_27_T3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[m];
        String[] strs = new String[m];
        int ans = 1;
        sc.nextLine();
        String strBig = sc.nextLine();
        for (int i = 0; i < m; i++) {
            nums[i] = sc.nextInt();
        }
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            strs[i] = sc.nextLine();
        }

        System.out.println(ans);
    }
}
