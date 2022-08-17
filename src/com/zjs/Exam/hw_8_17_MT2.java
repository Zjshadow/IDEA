package com.zjs.Exam;

import java.util.Scanner;

public class hw_8_17_MT2 {

    public static void main(String[] args) {

        System.out.println(calculate("98", "4"));
//        System.out.println(calculate("879", "636"));
//        System.out.println(calculate("825489235", "87987"));
//        System.out.println(calculate("8763845638363774673957584937685934737", "763845638363774673957584937685934"));
    }

    public static String calculate(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int[] result = new int[len1 > len2 ? len1 + 1 : len2 + 1];

        // 逆向遍历两个数组
        int i, j, max;
        int onesPlace, tensPlace, sum;
        for (i = len1 - 1, j = len2 - 1; i >= 0 && j >= 0; i--, j--) {
            max = Math.max(i, j);
            sum = Integer.parseInt(String.valueOf(arr1[i])) + Integer.parseInt(String.valueOf(arr2[j])) + result[max + 1];
            onesPlace = sum % 10;
            tensPlace = sum / 10;
            result[max + 1] = onesPlace;
            result[max] = tensPlace;
        }

        // 遍历剩下未遍历的部分
        if (i >= 0) {
            for (; i >= 0; i--) {
                sum = Integer.parseInt(String.valueOf(arr1[i])) + result[i + 1];
                onesPlace = sum % 10;
                tensPlace = sum / 10;
                result[i + 1] = onesPlace;
                result[i] = tensPlace;
            }
        }
        if (j >= 0) {
            for (; j >= 0; j--) {
                sum = Integer.parseInt(String.valueOf(arr2[j])) + result[j + 1];
                onesPlace = sum % 10;
                tensPlace = sum / 10;
                result[j + 1] = onesPlace;
                result[j] = tensPlace;
            }
        }

        // 将result数组转化成字符串并返回
        StringBuilder strBuilder = new StringBuilder();
        for (i = 0; i < result.length; i++) {
            if (i == 0 && result[i] == 0) {
                continue;
            }
            strBuilder.append(result[i]);
        }
        return strBuilder.toString();
    }

}