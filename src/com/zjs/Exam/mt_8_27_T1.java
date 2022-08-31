package com.zjs.Exam;

import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/13 15:58
 **/
public class mt_8_27_T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        char[] str1 = sc.nextLine().toCharArray();
        char[] str2 = sc.nextLine().toCharArray();

        int idx1 = 0, idx2 = 0, ans = 0;
        while (idx1 < n && idx2 < m) {
            if (str1[idx1] == str2[idx2] || str2[idx2] == '*') {
                idx1++;
                idx2++;
            }
            else {
                idx1 = idx1 - idx2 + 1;
                idx2 = 0;
            }
            if (idx2 == m) {
                ans++;
                idx1 = idx1 - idx2 + 1;
                idx2 = 0;
            }
        }
        System.out.println(ans);
    }
}
