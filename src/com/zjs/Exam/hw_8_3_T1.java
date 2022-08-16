package com.zjs.Exam;
import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/3 19:22
 **/
public class hw_8_3_T1 {
    public static void main(String[] args) {
        // 100101000001001010000100101
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int[] res = sub(s);
        if (res[0] == 0 && res[1] == 0) {
            System.out.println(-1);
        }
        else {
            System.out.print(s.substring(0, res[0]) + " ");
            System.out.print(s.substring(res[0], res[1]) + " ");
            System.out.print(s.substring(res[1], s.length()));
        }
    }

    public static int[] sub(String s) {
        for (int i = 1; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String str1 = s.substring(0, i);
                String str2 = s.substring(i, j);
                String str3 = s.substring(j, s.length());
                if (isEqual(str1, str2) && isEqual(str2, str3)) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {0, 0};
    }

    public static boolean isEqual(String a, String b) {
        int i = 0;
        int j = 0;
        // 去除前置0
        while (i < a.length() && a.charAt(i) == '0') {
            i++;
        }
        while (j < b.length() && b.charAt(j) == '0') {
            j++;
        }
        if (a.length() - i != b.length() - j) {
            return false;
        }

        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) != b.charAt(j)) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}
