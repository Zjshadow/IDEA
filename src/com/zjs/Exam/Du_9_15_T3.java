package com.zjs.Exam;

import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/9/15 18:58
 **/
public class Du_9_15_T3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            int ans = 0;
            int left = 0;
            int right = left + k;
            while (right < n) {
                if (str.charAt(left) != str.charAt(right)) {
                    ans++;
                }
                left++;
                right++;
            }
            System.out.println(ans);
        }
    }
}
