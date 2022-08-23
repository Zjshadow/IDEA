package com.zjs.Exam;

import com.zjs.leecode.Solution;

import java.util.Arrays;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/19 19:25
 **/
public class MS_8_19_T1 {
    public static void main(String[] args) {
        int[] x = new int[] {2, 4, 2, 6, 7, 1};
        int[] y = new int[] {0, 5, 3, 2, 1, 5};
        int w = 2;
        System.out.println(Solution(x, y, w));
    }

    public static int Solution(int[] X, int[] Y, int W) {
        Arrays.sort(X);
        int res = 1;

        int left = X[0];
        int right = left + W;
        for (int i = 0; i < X.length; i++) {
            if (X[i] > right) {
                left = X[i];
                right = left + W;
                res++;
            }
        }

        return res;
    }
}
