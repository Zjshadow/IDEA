package com.zjs.Exam;

import java.util.*;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/7/29 13:41
 **/
public class wl_7_29_T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int ans = 0;
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            ans += a[i];
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[] {a[i], b[i] - a[i], c[i]});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] l1, int[] l2) {
                return l2[1] - l1[1];
            }
        });
//        一维数组
        int[] dp = new int[k + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = k; j >= list.get(i)[2]; --j) {
                /*问题转化为背包问题，即求(作弊-不作弊)的最大值，weight即为c[i]，价值为b[i]-a[i]*/
                dp[j] = Math.max(dp[j], dp[j - list.get(i)[2]] + list.get(i)[1]);
            }
        }
        int res = dp[k] + 1500 + ans;
//        二维数组有错误
//        int[][] dp = new int[n + 1][k + 1];
//
//        // weight数组的大小 就是物品个数
//        for(int i = 0; i < n; i++) { // 遍历物品
//            for(int j = 0; j < k; j++) { // 遍历背包容量
//                if (j < list.get(i)[2]){
//                    dp[i][j] = dp[i - 1][j];
//                }else{
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - list.get(i)[2]] + list.get(i)[1]);
//                }
//            }
//        }
//        int res = dp[n][k] + 1500 + ans;
        System.out.println(res);
    }
}
