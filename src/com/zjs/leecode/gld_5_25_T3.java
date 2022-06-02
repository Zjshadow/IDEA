package com.zjs.leecode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/5/25 18:52
 **/
public class gld_5_25_T3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] time = new int[n][2];
        for (int i = 0; i < n; i++) {
            time[i][0] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            time[i][1] = in.nextInt();
        }

        Arrays.sort(time, new Comparator<int[]>() {
            public int compare(int[] num1, int[] num2) {
                return num1[0] - num2[0];
            }
        });

        int count = 0;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < time.length; i++) {
            if (end <= time[i][0]) {
                end = time[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
