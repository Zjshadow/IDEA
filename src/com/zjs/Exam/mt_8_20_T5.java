package com.zjs.Exam;


import java.util.Scanner;

public class mt_8_20_T5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < n; i++) {
            str.append(str1.charAt(i));
            str.append(str2.charAt(i));
        }

        System.out.println(str.toString());
    }
}
