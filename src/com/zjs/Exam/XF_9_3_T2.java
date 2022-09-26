package com.zjs.Exam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/9/3 19:54
 **/
public class XF_9_3_T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int M = sc.nextInt();
        int[][] data1 = new int[M][2];
        int[][] data2 = new int[M][2];
        for (int i = 0; i < M; i++) {
            data1[i][0] = sc.nextInt();
            data2[i][0] = data1[i][0];
            data1[i][1] = sc.nextInt();
            data2[i][1] = data1[i][1];
        }
        // 按照左边界从小到大排序
        Arrays.sort(data1, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 左边界相等 右边界从大到小
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });
        // 按照右边界从小到大排序
        Arrays.sort(data2, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 右边界相等 左边界从大到小
                if (o1[1] == o2[1]) {
                    return o2[0] - o1[0];
                }
                return o1[1] - o2[1];
            }
        });
        for (int i = 0; i < M; i++) {
            System.out.println(data1[i][0] + " " + data1[i][1]);
        }
        for (int i = 0; i < M; i++) {
            System.out.println(data2[i][0] + " " + data2[i][1]);
        }
        int left = 1;
        int right = L;
        int ans = 0;
        for (int i = 0; i < M; i++) {
            if (data1[i][0] <= left) {
                ans++;
                left = data1[i][1];
                if (data1[i][1] >= right) {
                    System.out.println(ans);
                    break;
                }
            }
            else {
                System.out.println("fail");
                break;
            }
            if (data2[M - i - 1][1] >= right) {
                ans++;
                right = data2[M - i - 1][0];
                if (data2[M - i - 1][0] <= left) {
                    System.out.println(ans);
                    break;
                }
            }
            else {
                System.out.println("fail");
                break;
            }

            if (left + 1 >= right) {
                System.out.println(ans);
                break;
            }
        }
    }
}
