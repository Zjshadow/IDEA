package com.zjs.Exam;

import java.util.*;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/27 19:35
 **/
public class ALi_8_29_T2 {
    private static int[][] flag;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Character, Integer> colorScore = new HashMap<>();
        colorScore.put('r',1);
        colorScore.put('b',2);
        colorScore.put('g',3);
        colorScore.put('p',5);
        Queue<Integer> score = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        char[][] grid = new char[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            grid[i] = sc.nextLine().toCharArray();
        }
        // 第一次遍历得到各个岛屿的面积
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 'X') {
                    // 遍历得到该陆地区域所属的岛屿面积
                    int s = colorScore.get(grid[i][j]);
                    int IslandArea = dfs(grid, i, j, grid[i][j]);
                    System.out.println(IslandArea);
                    // 存储岛屿ID以及对应的面积
                    score.offer(IslandArea * s);
                }
            }
        }
        int ans = 0;
        if (k > score.size()) {
            for (int i = 0; i < score.size(); i++) {
                ans += score.poll();
            }
        }
        else {
            for (int i = 0; i < k; i++) {
                ans += score.poll();
            }
        }

        System.out.println(ans);

    }
    // 返回该陆网格延伸的某岛屿面积
    public static int dfs(char[][] grid, int x, int y, char f) {
        if (!inArea(grid, x, y))
            return 0;

        if (grid[x][y] != f)
            return 0;
        // 避免重复遍历陆地节点，修改标记为X
        grid[x][y] = 'X';

        int area = 1 + dfs(grid, x - 1, y, f) + dfs(grid, x + 1, y, f) + dfs(grid, x, y - 1, f) + dfs(grid, x, y + 1, f);
        return area;
    }
    // 判断是否出界
    public static boolean inArea(char[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
