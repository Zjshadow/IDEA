package com.zjs.Exam;

import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/13 15:58
 **/
public class mt_8_13_T3_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int idx = 0;
            if (i != n - 2) {
                idx = 2;
            }
            for (int j = n - i; j <= n; j++) {
                if (j == n - i) {
                    continue;
                }
                idx = (idx + 3) % j;
            }
            res[idx] = arr[i];
        }


        for (int i = 0; i < n - 1; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.print(res[n - 1]);
    }
}
