package com.zjs.Exam;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/2 19:07
 **/
public class Main {
    public static void main(String[] args) {
        int a = -1;
        int b = MIN_VALUE;


        System.out.println(avgLong(a,b));
        System.out.println(avg(a,b));
    }

    public static int avg(int a, int b) {
        int avg = 0;
        if ((a ^ b) < 0) {
            avg = (a + b)/2;
        }
        else {
            if (a >= b) {
                if (a < 0) {
                    avg = (-b + (- a + b) / 2);
                }
                avg = b + (a - b)/2;
            }
            else {
                avg = a + (b - a)/2;
            }
        }
        return avg;
    }

    public static Long avgLong(int a, int b) {
        long aL = a;
        long bL = b;
        return (aL + bL)/2;
    }
}
