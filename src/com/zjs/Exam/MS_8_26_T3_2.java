package com.zjs.Exam;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/16 18:56
 **/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MS_8_26_T3 {
    public static void main(String[] args) {
        int[] a = new int[] {1, 3, 2};
        int[] b = new int[] {1, 2, 2};
        System.out.println(solution(a, b));
    }

    public static int solution(int[] A, int[] B) {
        // write your code in Java 8 (Java SE 8)
        int len = A.length;
        int min = Integer.MAX_VALUE;
        Set<Integer> hs = new HashSet<>();

        for (int i = 0; i < len; i++) {
            hs.add(A[i]);
            hs.add(B[i]);
            if (A[i] == B[i]) {
                continue;
            }

            min = Math.min(min, Math.min(A[i], B[i]));
        }

        for (int i = 1; i < min; i++) {
            if (!hs.contains(i)) {
                min = i;
                break;
            }
        }
        return min;
    }

}
