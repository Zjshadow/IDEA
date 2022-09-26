package com.zjs.Exam;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/9/18 10:13
 **/
public class ZJ_9_18_T3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(helper(str));
    }
    public static int helper(String str) {
        int[] cnt = new int[4];
        int flag = 0;
        int len = str.length();
        Arrays.fill(cnt, -len / 4);

        for (int i = 0; i < len; i++) {
            char charS = str.charAt(i);
            int idx = get(charS);
            cnt[idx]++;
            if (cnt[idx] == 1) {
                flag++;
            }
        }

        if (flag == 0) {
            return 0;
        }
        int minLen = len;
        int left = 0, right = 0;
        while (right < len) {
            int curIdx = get(str.charAt(right));
            cnt[curIdx]--;
            if (cnt[curIdx] == 0) {
                flag--;
            }
            while (left <= right && flag == 0) {
                minLen = Math.min(minLen, right - left + 1);
                int preIdx = get(str.charAt(left));
                cnt[preIdx]++;
                if (cnt[preIdx] == 1) {
                    flag++;
                }
                left++;
            }
            right++;
        }
        return minLen;

    }
    public static int get(char s){
        switch (s) {
            case 'A':
                return 0;
            case 'S':
                return 1;
            case 'D':
                return 2;
            case 'F':
                return 3;
            default:
                return -1;
        }
    }
}
