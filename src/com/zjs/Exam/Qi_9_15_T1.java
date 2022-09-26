package com.zjs.Exam;

import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/9/15 20:31
 **/
public class Qi_9_15_T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strA = sc.nextLine().split(",");
        String[] strB = sc.nextLine().split(",");
        int[] costA = new int[strA.length];
        int[] costB = new int[strB.length];
        int[][] cost = new int[strA.length][2];
        int ans = 0;
        for (int i = 0; i < strA.length; i++) {
            costA[i] = Integer.parseInt(strA[i]);
            costB[i] = Integer.parseInt(strB[i]);
            if (costA[i] < costB[i]) {
                cost[i][0] = costA[i];
                cost[i][1] = 1;
                ans += costA[i]*0.6;
            }
            else {
                cost[i][0] = costB[i];
                cost[i][1] = 2;
                ans += costB[i];
            }
        }

        System.out.println(ans);
    }
}
