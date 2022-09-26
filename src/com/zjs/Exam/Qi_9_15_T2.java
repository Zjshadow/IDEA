package com.zjs.Exam;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/9/15 20:31
 **/
public class Qi_9_15_T2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] nums = new int[][]{{0,5},{1,1}};
        System.out.println(getMinLen(nums));
    }

    public static int getMinLen (int[][] points) {
        // write code here
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] + o1[1]) - (o2[0] + o2[1]);
            }
        });
        int ans = 0;
        int[] start = new int[]{0, 0};
        for (int i = 0; i < points.length; i++) {
            ans += Math.abs(points[i][0] - start[0]) + Math.abs(points[i][1] - start[1]);
            start[0] = points[i][0];
            start[1] = points[i][1];
        }
        return ans;
    }
}

