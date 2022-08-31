package com.zjs.Exam;

import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/27 19:35
 **/
public class JD_8_27_T3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 6) {
            System.out.println(1);
        }
        else if (n < 6) {
            System.out.println(0);
        }
        else {
            int size = n - 6;

            System.out.println(n%3);
        }
    }
    
}
