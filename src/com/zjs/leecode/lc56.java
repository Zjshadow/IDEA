package com.zjs.leecode;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/6/10 21:36
 **/
public class lc56 {

    public static void main(String[] args) {

    }

    @Test
    public void test(){
        int[][] intervals = new int[][] {{1,3},{2,6},{8,10},{15,18}};
        int[][] ans = merge(intervals);
        System.out.println();
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
    }

    public int[][] merge(int[][] intervals) {
        int cnt = 0;
        int n = intervals.length;
        // 按照右边边界排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });
        // 从左向右，优先选择右边界小的
        List<int[]> res = new ArrayList<int[]>();
        int start = intervals[0][0], end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // 注意是等于 区间边界可以重叠[0,1][1,2]
            if (end <= intervals[i][0]) {
                end = intervals[i][1];
            }
            else {
                start = intervals[i][0];
                start = intervals[i][1];
            }
            res.add(new int[]{start, end});
        }
        // cnt为不重叠数量，n-cnt即为需要删除的重叠数量
        int[][] ans = new int[res.size()][];
        return res.toArray(ans);

    }
}
