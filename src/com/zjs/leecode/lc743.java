package com.zjs.leecode;

import org.junit.Test;

import java.util.*;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/6/17 14:38
 **/
public class lc743 {
    int INF = 0x3f3f3f3f;

    @Test
    public void test(){
        int[][] times = new int[][] {{1,2,1},{2,3,7},{1,3,4},{2,1,2}};
        System.out.println(networkDelayTime(times, 3,2));
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        // 邻接矩阵
        int[][] w = new int[n + 1][n + 1];
        // 访问记录
        boolean[] isVis = new boolean[n + 1];
        // 距离
        int[] dis = new int[n + 1];

        // 初始化邻接矩阵
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                w[i][j] = w[j][i] = i == j ? 0 : INF;
            }
        }

        // 读取times，存入邻接矩阵
        for (int[] time : times) {
            int u = time[0], v = time[1];
            w[u][v] = time[2];
        }

        // Dijkstra算法
        Arrays.fill(isVis, false);
        Arrays.fill(dis, INF);

        dis[k] = 0;
        // N次迭代
        for (int i = 1; i <= n; i++) {
            // 寻找未访问且最小距离点作为选定点x，更新距离
            int x = -1;
            for (int j = 1; j <= n; j++) {
                if (!isVis[j] && (x == -1 || dis[j] < dis[x])) {
                    x = j;
                }
            }

            isVis[x] = true;
            // 根据选定点x更新距离
            for (int y = 1; y <= n; y++) {
                dis[y] = Math.min(dis[y], dis[x] + w[x][y]);
            }
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print(dis[i] + " ");
            res = Math.max(res, dis[i]);
        }

        return res == INF ? -1 : res;
    }
}