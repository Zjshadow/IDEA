package com.zjs.leecode;

import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/5/19 14:39
 **/
public class hw_5_19_T1_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] ans = new int[6][14];
        int row = 0, col = 0;
        for (int i = 0; i < n; i++) {
            row = scanner.nextInt();
            col = scanner.nextInt();
            ans[row][col] = 1;
            ans[5][col]++;
        }

        for (int i =0; i < 14; i++) {
            if (ans[5][i] == 4) {
                for (int j = 1; j < 5; j++) {
                    System.out.println(j + " " + i);
                }
                ans[5][i] = 0;
            }
        }

        for (int i =0; i < 14; i++) {
            int flag = 0;
            if (ans[5][i] == 3) {
                for (int j = 1; j < 5; j++) {
                    if (ans[j][i] == 1 && flag < 2) {
                        System.out.println(j + " " + i);
                        flag++;
                        ans[j][i] = 0;
                        ans[5][i]--;
                    }
                }
            }
        }

        for (int i =0; i < 14; i++) {
            if (ans[5][i] == 2) {
                for (int j = 1; j < 5; j++) {
                    if (ans[j][i] == 1) {
                        System.out.println(j + " " + i);
                    }
                }
                ans[5][i] = 0;
            }
        }

        for (int i =0; i < 14; i++) {
            if (ans[5][i] == 1) {
                for (int j = 1; j < 5; j++) {
                    if (ans[j][i] == 1) {
                        System.out.println(j + " " + i);
                    }
                }
                ans[5][i] = 0;
            }
        }
    }
}
