package com.zjs.leecode;

import java.util.Scanner;


/**
 * @author zjs
 * @version 1.0
 * @data 2022/7/23 19:47
 **/
public class xf_7_23_T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        double PI = 3.1415927;
        for (int i = 0; i < N; i++) {
            int a = in.nextInt();
            double ans = Math.round(a * 0.5 * (1 - Math.cos(2 * PI * i / N)));
            int res = (int) ans;
            if (i != N - 1){
                System.out.print(res + " ");
            }
            else {
                System.out.print(res);
            }
        }
    }
}
