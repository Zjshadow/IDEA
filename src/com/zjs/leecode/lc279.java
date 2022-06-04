package com.zjs.leecode;

import org.junit.Test;

import java.util.*;

public class lc279 {

    @Test
    public void test(){
        int num = 13;
        int res = numSquares(num);
        System.out.println(res);
    }

    public int numSquares(int n) {
        // BFS解法
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(n);
        visited.add(n);
        int step = 1;

        List<Integer> squares = gernerateSquares(n);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();

                // 层扩展
                for (int j : squares) {
                    int tmp = cur - j;
                    if (tmp == 0) {
                        return step;
                    }
                    if (tmp < 0) {
                        break;
                    }
                    if (!visited.contains(tmp)){
                        queue.offer(tmp);
                        visited.add(tmp);
                    }
                }
            }
            step++;
        }

        return n;
    }

    public List gernerateSquares(int n) {
        List squares = new LinkedList<Integer>();
        int square = 1;

        while (square <= n) {
            squares.add(square);
            square++;
            square = square*square;
        }

        return squares;
    }
}
