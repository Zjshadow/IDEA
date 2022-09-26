package com.zjs.Exam;

import java.util.*;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/9/14 19:46
 **/
public class mihyo_9_14_T3 {
    static class A<T>{
        public T get(T t){
            return t;
        }
    }
    static class TreeNode {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeNode root = new TreeNode(n);
        int x = sc.nextInt();
        int[][] nums = new int[n - 1][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
    }
}
