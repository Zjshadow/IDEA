package com.zjs.Exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/9/18 10:13
 **/
public class ZJ_9_18_T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        // 上一层有效区间
        List<int[]> preArea = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 当前层有效区间
            List<int[]> curArea = new ArrayList<>();
            int m = sc.nextInt();
            for (int j = 0; j < m ;j++) {
                int left = sc.nextInt();
                if (i == 0) {
                    curArea.add(new int[]{left, left + 100});
                    res++;
                }
                else {
                    if (isValid(left, preArea)) {
                        curArea.add(new int[]{left, left + 100});
                        res++;
                    }
                }
            }
            // 更新有效区间
            preArea = curArea;
        }

        System.out.println(res);
    }

    public static boolean isValid(int left, List<int[]> area) {
        int mid = left + 50;
        int right = left + 100;
        boolean flag = false;
        for (int[] a: area){
            if (mid > a[0] && mid < a[1]) {
                return true;
            }
            if (left > a[0] && left < a[1]) {
                flag = true;
            }
            if (right > a[0] && right < a[1] && flag) {
                return true;
            }
        }

        return false;
    }
}
