package com.zjs.Exam;

import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/9/4 15:03
 **/
public class WY_9_4_T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();
        if (k <= t || k > n) {
            System.out.println(-1);
        }

        StringBuilder strBuilder = new StringBuilder();
        int m = k - t - 1;
        int x = n - k - m;
        if (x < 0) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i <= t; i++) {
            strBuilder.append(1);
        }
        for (int i = 0; i < m; i++) {
            strBuilder.append(0);
            strBuilder.append(1);
        }
        for (int i = 0; i < x; i++) {
            strBuilder.append(0);
        }

        System.out.println(strBuilder);
    }
}
