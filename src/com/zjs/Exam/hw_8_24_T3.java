package com.zjs.Exam;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/3 19:22
 **/
public class hw_8_24_T3 {
    private static int[][] flag;
    private static HashMap<Integer, Integer> areaIsland;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        // 第一次遍历尝试将某个0变为1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int[][] gridCopy = new int[m][n];
                    for(int k = 0;k < m;k++) {
                        gridCopy[k] = Arrays.copyOf(grid[k],grid[k].length);
                    }
                    gridCopy[i][j] = 1;
                    int curMax = largestArea(gridCopy);
//                    System.out.println(i + " " + j + " " + curMax);
                    ans = Math.max(ans, curMax);
                    gridCopy[i][j] = 0;
                }
            }
        }
        System.out.println(ans);
    }
    public static int largestArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        int maxIsland = 0;
        // 标记数组，网格所在岛屿id，海洋为0，岛屿id从f = 1计数
        flag = new int[m][n];
        int f = 1;
        // 存储岛屿id和相应面积
        areaIsland = new HashMap<Integer, Integer>();

        // 第一次遍历得到各个岛屿的面积
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 遍历得到该陆地区域所属的岛屿面积
                    int IslandArea = dfs(grid, i, j, f);
                    maxIsland = Math.max(ans, IslandArea);
                    // 存储岛屿ID以及对应的面积
                    areaIsland.put(f, IslandArea);
                    f++;
                }
            }
        }

        // 第二次遍历海洋区域
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    // 遍历得到通过该海洋区域连接之后的岛屿面积
                    int OceanArea = oceanArea(grid, i, j);
                    ans = Math.max(ans, OceanArea);
                }
            }
        }

        return Math.max(ans, maxIsland);
    }

    // 返回海洋网格变为陆地之后的连通岛屿总面积
    public static int oceanArea(int[][] grid, int x, int y) {
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

    // 返回海洋网格周边某方向的临近岛屿信息（岛屿id，岛屿面积）；如果不为岛屿（比如海洋/出界）返回（0,0）
    public static int[] area(int[][] flag, int x, int y) {
        if (!inArea(flag, x, y))
            return  new int[]{0, 0};

        if (flag[x][y] == 0)
            return new int[]{0, 0};

        int areaOne = areaIsland.get(flag[x][y]);
        return new int[]{flag[x][y], areaOne};
    }

    // 返回该陆网格延伸的某岛屿面积
    public static int dfs(int[][] grid, int x, int y, int f) {
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

    // 判断是否出界
    public static boolean inArea(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }

}
