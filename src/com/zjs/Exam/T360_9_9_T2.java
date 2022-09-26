package com.zjs.Exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/9/9 16:07
 **/
public class T360_9_9_T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
//        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            String[] str = sc.nextLine().split("=");
            int left = cal(str[0]);
            int right = cal(str[1]);
            if (left == right) {
                System.out.println("Yes");
            }
            else {
                if (left < right) {
                    bijiao(str[0], right);
                }
                else {
                    bijiao(str[1], left);
                }
            }
        }
    }

    public static boolean bijiao(String a, int num) {
        boolean res = true;

        return res;

    }

    public static int cal(String s) {
        int res = 0;

        return res;
    }
}
