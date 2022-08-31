package com.zjs.Exam;

import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/27 19:35
 **/
public class JD_8_27_T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        char[] charArray = str.toCharArray();

        // 变大写
        for (int i = 0; i < k; i++) {
            if (charArray[i] > 96) {
                charArray[i] -= 32;
            }
        }

        // 变小写
        for (int j = k; j < str.length(); j++) {
            if (charArray[j] < 91) {
                charArray[j] += 32;
            }
        }

        System.out.println(String.valueOf(charArray));
    }

}
