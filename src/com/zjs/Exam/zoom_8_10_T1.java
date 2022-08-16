package com.zjs.Exam;

import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/10 20:00
 **/
public class zoom_8_10_T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.nextLine();
        char[] charArray = str.toCharArray();
//        for (int i = 0; i < n; i++) {
//            charArray[i] = str.charAt(i);
//        }
        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
//          处理边关系
        }


    }
}
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
