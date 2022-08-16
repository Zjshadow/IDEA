package com.zjs.Exam;

import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/13 15:58
 **/
public class Main_2 {
    public static int val = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        String order = sc.next();
        char[] chars = order.toCharArray();
        if (isClean(n, m, chars)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
        System.out.println(val);
    }

    public static boolean isClean(int n, int m, char[] chars) {
        int cnt = 1;
        int curi = 0;
        int curj = 0;
        int[][] room = new int[n][m];
        room[0][0] = 1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'W') {
                curi--;
            }
            else if (chars[i] == 'A') {
                curj--;
            }
            else if (chars[i] == 'S') {
                curi++;
            }
            else if (chars[i] == 'D') {
                curj++;
            }
            if (room[curi][curj] == 0) {
                cnt++;
                room[curi][curj] = 1;
            }

            if (cnt == n * m) {
                val = i + 1;
                return true;
            }
        }

        if (cnt == n * m) {
            val = chars.length;
            return true;
        }
        val = n * m - cnt;
        return false;
    }
}
