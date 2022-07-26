package com.zjs.leecode;

import org.junit.Test;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/7/18 17:53
 **/
public class lc1020 {
    @Test
    public void test() {
        int[][] grid = new int[][] {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        int ans = numEnclaves(grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(flag[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(ans);

    }
    private int[][] dir = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private boolean[][] flag;
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        flag = new boolean[m][n];
        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(flag[i][j] + " ");
            }
            System.out.println();
        }
        // 周边遍历第一行和最后一行的陆地
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1) {
                dfs(grid, 0, i);
            }
            if (grid[m - 1][i] == 1) {
                dfs(grid, m - 1, i);
            }
        }
        // 周边遍历第一列和最后一列的陆地
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                dfs(grid, i, 0);
            }
            if (grid[i][n - 1] == 1) {
                dfs(grid, i, n - 1);
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (flag[i][j] == true) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public void dfs(int[][] grid, int x, int y) {
        if (flag[x][y]) {
            return;
        }
        flag[x][y] = true;

        for (int[] d : dir) {
            int m = x + d[0], n = y + d[1];
            if (inArea(grid, m, n) && grid[m][n] == 1) {
                dfs(grid, m, n);
            }
        }
    }

    public boolean inArea(int[][] grid, int m, int n) {
        return m >= 0 && m < grid.length && n >= 0 && n < grid[0].length;
    }
}
