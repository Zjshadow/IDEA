package com.zjs.Exam;

import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/13 15:58
 **/
public class mt_8_27_T4_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int[] elec = new int[n];
        int[] time = new int[n];

        for (int i = 0; i < n; i++) {
            elec[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            time[i] = sc.nextInt();
        }

        sc.close();

        if (elec[0] > b) {
            System.out.println(-1);
            return;
        }

        int res = dfs(1, n, b - elec[0], elec, time, time[0], time[0]);
        System.out.println(res);
    }

    public static int dfs(int idx, int n, int b, int[] p,int[] t, int time, int ti) {
        if (idx == n) {
            return time;
        }
        if (b == 0 || b < p[idx]) {
            return dfs(idx + 1, n, b, p, t, time + ti, ti);
        }
        else {
            return Math.min(dfs(idx+1, n, b, p, t, time + ti, ti),
                    Math.max(time, dfs(idx + 1, n, b - p[idx], p, t, t[idx], t[idx])));
        }
    }
}
