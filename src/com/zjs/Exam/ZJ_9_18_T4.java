package com.zjs.Exam;

import java.util.*;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/9/18 10:13
 **/
public class ZJ_9_18_T4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Queue<int[]> res = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0] == o1[0]) {
                    return o1[1] - o2[1];
                }
                return o2[0] - o1[0];
            }
        });
        int left = 0, right = 0;

        for (int i = 0; i < nums.length; i++) {
            right = i;
            int min = nums[i],max = nums[i];
            while (right < nums.length) {
                int num = nums[right];
                max = Math.max(num, max);
                min = Math.min(num, min);
                if (max - min <= k) {
                    if (right == nums.length - 1) {
                        res.add(new int[]{right - left + 1,left + 1, right + 1});
                        break;
                    }
                    right++;
                }
                else {
                    res.add(new int[]{right - left,left + 1, right});
                    break;
                }
            }
        }

        for (int[] q : res) {
            System.out.println(q[0] + " " + q[1] + " " + q[2]);
        }
    }
}
