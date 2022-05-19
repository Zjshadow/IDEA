package com.zjs.leecode;

import org.junit.Test;

import java.util.*;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/5/13 11:28
 **/
public class lc827 {
    @Test
    public void test(){
        int[][] grid = {{1, 0},{0, 1}};
        System.out.println(largestIsland(grid));
    }

    private int[][] flag;
    private HashMap<Integer, Integer> areaIsland;
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        flag = new int[n][n];
        areaIsland = new HashMap<Integer, Integer>();
        int f = 1;
        // 第一次遍历得到各个岛屿的面积
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 遍历得到该陆地区域所属的岛屿面积
                    int IslandArea = dfs(grid, i, j, f);
                    // 存储岛屿ID以及对应的面积
                    areaIsland.put(f, IslandArea);
                    f++;
                }
            }
        }

        // 第二次遍历海洋区域
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    // 遍历得到通过该海洋区域连接之后的岛屿面积
                    int OceanArea = oceanArea(grid, i, j);
                    ans = Math.max(ans, OceanArea);
                }
            }
        }

        return ans;

    }

    public int oceanArea(int[][] grid, int x, int y) {
        int a = 0;
        HashMap<Integer, Integer> areaOcean = new HashMap<Integer, Integer>();
        int[] area1 = area(flag, x - 1, y);
        int[] area2 = area(flag, x + 1, y);
        int[] area3 = area(flag, x, y - 1);
        int[] area4 = area(flag, x, y + 1);

        areaOcean.put(area1[0], area1[1]);
        areaOcean.put(area2[0], area2[1]);
        areaOcean.put(area3[0], area3[1]);
        areaOcean.put(area4[0], area4[1]);

        for(int value: areaOcean.values()) {
            a += value;
        }
        return a + 1;
    }

    public int[] area(int[][] flag, int x, int y) {
        if (!inArea(flag, x, y))
            return  new int[]{0, 0};

        if (flag[x][y] == 0)
            return new int[]{0, 0};

        int areaOne = areaIsland.get(flag[x][y]);
        return new int[]{flag[x][y], areaOne};
    }

    public int dfs(int[][] grid, int x, int y, int f) {
        if (!inArea(grid, x, y))
            return 0;

        if (grid[x][y] != 1)
            return 0;
        // 避免重复遍历陆地节点，修改标记为2
        grid[x][y] = 2;
        // 标记岛屿id
        flag[x][y] = f;

        int area = 1 + dfs(grid, x - 1, y, f) + dfs(grid, x + 1, y, f) + dfs(grid, x, y - 1, f) + dfs(grid, x, y + 1, f);
        return area;
    }

    public boolean inArea(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}