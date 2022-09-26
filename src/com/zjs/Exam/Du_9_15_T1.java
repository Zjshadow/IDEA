package com.zjs.Exam;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/9/15 18:58
 **/
public class Du_9_15_T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] cnt = new int[26];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            Arrays.fill(cnt, 0);
            for (int j = 0; j < str.length(); j++) {
                cnt[str.charAt(j) - 'a']++;
            }
            Arrays.sort(cnt);
            int max = cnt[25];
            int min = Integer.MAX_VALUE;
            for (int k = 0; k < 26; k++) {
                if (cnt[k] != 0) {
                    min = Math.min(min, cnt[k]);
                }
            }
            ans = Math.max(ans, max - min);
        }
        System.out.println(ans);
    }
}
