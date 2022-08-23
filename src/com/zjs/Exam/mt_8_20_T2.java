package com.zjs.Exam;


import java.util.*;

public class mt_8_20_T2 {
    static Map<String, Integer> res = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] loc = new int[3][2];
        int[] dis = new int[3];
        for (int i = 0; i < 3; i++) {
            loc[i][0] = sc.nextInt();
            loc[i][1] = sc.nextInt();
        }
        dis[0] = sc.nextInt();
        dis[1] = sc.nextInt();
        dis[2] = sc.nextInt();

        int[][] grid1 = new int[n + 1][n + 1];
        dfs(grid1, loc[0][0], loc[0][1], dis[0]);
        int[][] grid2 = new int[n + 1][n + 1];
        dfs(grid2, loc[1][0], loc[1][1], dis[1]);
        int[][] grid3 = new int[n + 1][n + 1];
        dfs(grid3, loc[2][0], loc[2][1], dis[2]);

        int[] ans = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        for (String x : res.keySet()) {
            if (res.get(x) == 3) {
                String[] s = x.split(" ");
                int[] arr = Arrays.asList(s).stream().mapToInt(Integer::parseInt).toArray();
                if (arr[0] < ans[0] || (arr[0] == ans[0] && arr[1] < ans[1])) {
                    ans[0] = arr[0];
                    ans[1] = arr[1];
                }
            }
        }

        System.out.println(ans[0] + " " + ans[1]);
    }
    public static void dfs(int[][] grid, int x, int y, int step) {
        if (!isArea(grid.length - 1, x, y))
            return;
        if (grid[x][y] != 0){
            return;
        }
        grid[x][y] = 1;
        if (step == 0) {
            String str = x + " " + y;
            res.put(str, res.getOrDefault(str, 0) + 1);
            return;
        }
        dfs(grid, x - 1, y, step - 1);
        dfs(grid, x + 1, y, step - 1);
        dfs(grid, x, y + 1, step - 1);
        dfs(grid, x, y - 1, step - 1);
    }
    public static boolean isArea(int n, int x, int y){
        return x > 0 && y > 0 && x <= n && y <= n;
    }
}
