package com.zjs.leecode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/6/7 17:10
 **/
public class lc452 {
    public static void main(String[] args) {

    }

    @Test
    public void test() {
        int[][] points = new int[][] {{-2147483646,-2147483645},{2147483646,2147483647}};
//        int[][] points = new int[][] {{1,5},{3,4}};
        int res = findMinArrowShots(points);
        System.out.println(res);
    }
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if (a[1] > b[1]) {
                    return 1;
                } else if (a[1] < b[1]) {
                    return -1;
                } else {
                    return 0;
                }
                // return a[1] - b[1];
            }
        });

        // int cnt = 0;
        // int end = Integer.MIN_VALUE;
        // 错解：[[-2147483648,2147483647]]
        int cnt = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (end < points[i][0]) {
                end = points[i][1];
                cnt++;
            }
        }
        return cnt;
    }
}
