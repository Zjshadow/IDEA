package com.zjs.Exam;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/9/19 15:53
 **/
public class HW_9_19_T2 {
    public static void main(String[] args) {
        String S = "ADOBECODEBANC                                                                                                                                                                       ";
        String T = "ABC";

        int n = S.length();
        int sum = 0;
        int[] tar = new int[100];
        for (char c : T.toCharArray()) {
            tar[c - 'A']++;
            if (tar[c - 'A'] == 1) {
                sum++;
            }
        }

        int len = Integer.MAX_VALUE;
        int l = 0, r = 0, cnt = 0;
        int[] hash = new int[100];
        int resL = 0, resR = 0;

        // 双指针
        while (r < n) {
            // 窗口右边移动
            while (r < n && cnt < sum) {
                int i = S.charAt(r) - 'A';
                hash[i]++;
                if (hash[i] == tar[i]) {
                    cnt++;
                }
                r++;
            }
            // 窗口左边移动
            while (l < r && cnt >= sum) {
                int i = S.charAt(l) - 'A';
                hash[i]--;
                if (hash[i] == tar[i] - 1) {
                    cnt--;
                }

                if (r - l < len) {
                    resL = l;
                    resR = r;
                    len = r - 1;
                }
                l++;
            }
        }

        if (resR == 0) {
            System.out.println("");
        }
        else {
            if (resR == n) {
                System.out.println(S.substring(resL));
            }
            else {
                System.out.println(S.substring(resL, resR));
            }
        }


    }
}
