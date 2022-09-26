package com.zjs.Exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/3 20:00
 **/
public class hw_8_31_T2 {
    static List<Integer> res = new ArrayList<>();
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        int startX = 0;
        int startY = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }
        boolean[][] isVisited = new boolean[m][n];
        dfs(grid, startX, startY, isVisited, 0);
        System.out.println(ans);
//        for (Integer i : res) {
//            System.out.println(i);
//        }
    }
    public static void dfs(int[][] grid, int x, int y, boolean[][] isVisited, int step) {
        if (!inArea(grid, x, y) || isVisited[x][y])
            return;
        // 墙
        if (grid[x][y] == 1) {
            return;
        }
        // 终点
        if (grid[x][y] == 3) {
//            step++;
            res.add(step);
            ans = Math.min(ans, step);
            return;
        }
        int left = 0, right = 0, up = 0, down = 0;
        boolean boomFlag = false;
        isVisited[x][y] = true;
        // 陷阱
        if (grid[x][y] == 4) {
            step += 3;
        }
        // 炸弹
        else if (grid[x][y] == 6){
            boomFlag = true;
            left = boom(grid, x - 1, y);
            right = boom(grid, x + 1, y);
            up = boom(grid, x, y - 1);
            down = boom(grid, x, y + 1);
            step++;
        }
        // 路
        else {
            step++;
        }

        dfs(grid, x - 1, y, isVisited, step);
        dfs(grid, x + 1, y, isVisited, step);
        dfs(grid, x, y - 1, isVisited, step);
        dfs(grid, x, y + 1, isVisited, step);
        if (boomFlag == true) {
            recover(grid, x - 1, y, left);
            recover(grid, x + 1, y, right);
            recover(grid, x, y - 1, up);
            recover(grid, x, y + 1, down);
        }

        isVisited[x][y] = false;
    }

    public static boolean inArea(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }

    // 返回炸之前的原始数值
    public static int boom(int[][] grid, int x, int y) {
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
            if (grid[x][y] == 1) {
                grid[x][y] = 0;
                return 1;
            }
            else {
                return grid[x][y];
            }
        }
        else {
            return -1;
        }
    }
    public static void recover(int[][] grid, int x, int y, int value) {
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
            grid[x][y] = value;
        }
    }
}



