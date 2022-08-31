package com.zjs.Exam;

import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/13 15:58
 **/
public class mt_8_27_T4 {
    public static int min = Integer.MAX_VALUE;
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

        int res = 0;
        System.out.println(res);
    }

    public static void dfs(int[] elec, int[] times, int i, int timeMax, int b, int time, int ti) {
        if (i == elec.length) {
            min = min < timeMax ? min : timeMax;
        }
        if (timeMax > min) return;
        if (b == 0 || b < elec[i]) {
            timeMax = timeMax > time + ti ? timeMax : time + ti;
            dfs(elec, times, i + 1, timeMax,b,time + ti,ti);
        }

        dfs(elec, times, i + 1, timeMax, b - elec[i], times[i], times[i]);
        timeMax = timeMax > time + ti ? timeMax : time + ti;

        dfs(elec, times, i + 1, timeMax, b, time + ti, time + ti);
    }
}
