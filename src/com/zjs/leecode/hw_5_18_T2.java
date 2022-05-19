package com.zjs.leecode;

import java.util.*;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/5/18 19:00
 **/
public class hw_5_18_T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        char[][] grid = new char[row][col];
        // 去除第一行输入的回车
        sc.nextLine();
        for (int i = 0; i < row; i++) {
            String str = sc.nextLine();
            char[] sChar = str.toCharArray();
            for (int j = 0; j < col; j++) {
                grid[i][j] = sChar[j];
            }
        }
        int x = sc.nextInt();
        int y = sc.nextInt();
        int cnt = sc.nextInt();

        //宝藏移动函数
        int[] res =  helper(grid, x, y, cnt);
        System.out.format("%d %d", res[0], res[1]);

    }
    public static int[] helper(char[][] grid, int x, int y, int cnt) {
        if (grid[x][y] == '.' || cnt == 0)
            return new int[] {x, y};

        if (grid[x][y] == '>') {
            if (inArea(grid, x, y + 1) && grid[x][y + 1] != '#') {
                return helper(grid, x, y + 1, cnt - 1);
            }
        }
        else if (grid[x][y] == '<') {
            if (inArea(grid, x, y - 1) && grid[x][y - 1] != '#') {
                return helper(grid, x, y - 1, cnt - 1);

            }
        }
        else if (grid[x][y] == '^') {
            if (inArea(grid, x - 1, y) && grid[x - 1][y] != '#') {
                return helper(grid, x - 1, y, cnt - 1);
            }
        }
        else  {
            if (inArea(grid, x + 1, y) && grid[x + 1][y] != '#') {
                return helper(grid, x + 1, y, cnt - 1);
            }
        }
        return new int[]{x, y};
    }
    public static boolean inArea(char[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }
}
