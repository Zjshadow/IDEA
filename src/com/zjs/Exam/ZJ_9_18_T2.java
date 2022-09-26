package com.zjs.Exam;

import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/9/18 10:13
 **/
public class ZJ_9_18_T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int maxLen = 0;
        int curLen = 1;
        char preChar = str.charAt(0);
        for (int i = 1; i <str.length(); i++) {
            if (str.charAt(i) != preChar) {
                preChar = str.charAt(i);
                curLen++;
                maxLen = Math.max(maxLen, curLen);
            }
            else {
                preChar = str.charAt(i);
                curLen = 1;
            }
        }

        if (maxLen < 3) {
            System.out.println(0);
        }
        else {
            System.out.println(maxLen);
        }
    }
}
