package com.zjs.Exam;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/9/4 15:03
 **/
public class WY_9_4_T3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();

        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }

        for (int i = 0; i < k; i++) {
            queue.add(queue.poll() - x);
        }

        System.out.println(queue.peek());
    }
}
