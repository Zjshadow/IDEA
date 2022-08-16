package com.zjs.Exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/13 15:58
 **/
public class Main_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 1; j < n - 1; j++) {
            int sum = 3 * nums[j];
            map.merge(nums[j - 1], 1, Integer :: sum);
            for (int k = j + 1; k < n; k++) {
                if (map.containsKey(sum - nums[k])) {
                    res += map.get(sum - nums[k]);
                }
            }
        }
        System.out.println(res);
    }
}
