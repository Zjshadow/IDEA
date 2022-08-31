package com.zjs.Exam;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/13 15:58
 **/
public class mt_8_27_T5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int thingNum = sc.nextInt();
        int toyNum = sc.nextInt();
        int catTime = sc.nextInt();
        int[] toyTime = new int[toyNum];
        int[] thingArr = new int[thingNum];
        for (int i = 0; i < toyNum; i++) {
            toyTime[i] = sc.nextInt();
        }
        for (int i = 0; i < thingNum; i++) {
            thingArr[i] = sc.nextInt();
        }

        Queue<int[]> pq = new PriorityQueue<>(
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[1] - o2[1];
                    }
                }
        );
        int ans = 0;
        for (int i = 0; i < thingNum; i++) {
            if (thingArr[i] == 0) {
                if (!pq.isEmpty()) {
                    int time = pq.poll()[1];
                    if (time < catTime) {
                        ans += time;
                    }
                    else {
                        ans += catTime;
                    }
                }
                else {
                    ans += catTime;
                }
            }
            else {
                pq.add(new int[] {i, toyTime[thingArr[i] - 1]});
            }
        }
        System.out.println(ans);
    }
}
