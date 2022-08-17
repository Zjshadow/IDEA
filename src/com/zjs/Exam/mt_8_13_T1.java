package com.zjs.Exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/13 15:58
 **/
public class mt_8_13_T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] str1 = sc.nextLine().split(" ");
            int n = Integer.parseInt(str1[0]);
            int t = Integer.parseInt(str1[1]);
            String[] str2 = sc.nextLine().split(" ");
            int[] orders = new int[str2.length];
            for (int i = 0; i < str2.length; i++) {
                orders[i] = Integer.parseInt(str2[i]);
            }
            Arrays.sort(orders);
            System.out.println(minCounts(orders, t));
        }
    }

    public static int minCounts(int[] orders, int t) {
        int cur = t;
        int ans = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] < cur) {
                ans++;
            }
            else {
                cur = cur + t;
            }
        }

        return ans;
    }
}
