package com.zjs.Exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/27 19:35
 **/
public class JD_8_27_T2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int maxLen = 500000;
        int len = nums.length;

        int[] arrJi = new int[maxLen];
        int[] arrOu = new int[maxLen];

        int maxJi = 0;
        int maxJi2 = 0;
        int maxOu = 0;
        int maxOu2 = 0;

        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (i % 2 != 0) {
                arrJi[num]++;
                if (maxJi == 0 || arrJi[num] > arrJi[maxJi]) {
                    maxJi2 = maxJi;
                    maxJi = num;
                }
                else if (maxJi != num &&(maxJi2 == 0 || arrJi[num] > arrJi[maxJi2])) {
                    maxJi2 = num;
                }
            }
            else {
                arrOu[num]++;
                if (maxOu == 0 || arrOu[num] > arrOu[maxOu]) {
                    maxOu2 = maxOu;
                    maxOu = num;
                }
                else if (maxOu != num && (maxOu2 == 0) || arrOu[num] > arrOu[maxOu2]) {
                    maxOu2 = num;
                }
            }
        }

        if (maxOu != maxJi) {
            System.out.println(len - arrOu[maxOu] - arrJi[maxJi]);
        }
        else {
            System.out.println(len - Math.max(arrOu[maxOu] + arrJi[maxJi2], arrJi[maxJi] + arrOu[maxOu2]));
        }
    }
    
}
