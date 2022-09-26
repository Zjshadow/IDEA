package com.zjs.Exam;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/9/14 19:46
 **/
public class mihyo_9_14_T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        int y = sc.nextInt();
        Arrays.sort(nums);
        if (x == 0) {
            System.out.println("infinity");
        }
        else if (x == y) {
            System.out.println(0);
        }
        else {
            System.out.println(nums[y] - nums[y - 1]);
        }
    }
}
