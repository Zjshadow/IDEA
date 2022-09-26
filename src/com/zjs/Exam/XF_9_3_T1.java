package com.zjs.Exam;

import javax.xml.transform.Source;
import java.util.*;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/9/3 19:54
 **/
public class XF_9_3_T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data  = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }

        long[] res = new long[n];
        int maxVal = 0;
        List<Integer> idx = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res[i] = getData(i, data);
            System.out.print(res[i] + " ");

            if (i == 0) {
                continue;
            }

            if (Math.abs(res[i]) > maxVal) {
                idx = new ArrayList<>();
                idx.add(i);
                if (res[i] < 0) {
                    res[i] = - res[i];
                }
            }
            else if (Math.abs(res[i]) == maxVal) {
                idx.add(i);
            }
        }
        System.out.println();
        boolean flag = true;
        for (int i = 0; i < res.length; i++) {
            if (res[i] != res[0]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("NO");
            return;
        }
        HashSet<Long> set = new HashSet<>();
        for (Integer i : idx) {
            set.add(res[i]);
        }

        for (Long i : set) {
            System.out.print(i + " ");
        }
    }

    public static long getData(int k , int[] x) {
        int N = x.length;
        long res = 0;
        for (int n = 0; n <= N - k - 1; n++) {
            res += (long) x[n] * x[n + k];
        }
        for (int n = N - k; n <= N - 1; n++) {
            res += (long) x[n] * x[n + k - N];
        }

        return res;
    }
}
