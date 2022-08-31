package com.zjs.Exam;

import java.util.*;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/27 19:35
 **/
public class SF_8_31_T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        double res = logDiy(n,2);
        System.out.println(res);
    }
    private static double logDiy(double value, double base) {
        return Math.log(value) / Math.log(base);
    }
}
