package com.zjs.Exam;

import java.util.*;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/7/31 15:51
 **/
public class Main2 {
    public static int res = Integer.MIN_VALUE;
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() { };
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nodes = new int[n];
        List<TreeNode> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            nodes[i] = sc.nextInt();
            TreeNode tmp = new TreeNode(nodes[i]);
            list.add(tmp);
        }

        root = list.get(0);
        for (int j = 0; j < n; j++) {
            int f = sc.nextInt();
            if (f == 0) {continue;}
            if (list.get(f - 1).left == null) {
                list.get(f - 1).left = list.get(j);
            }
            else {
                list.get(f - 1).right = list.get(j);
            }
        }
        getPath(root);
        System.out.println(res);
    }
    public static int getPath(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftPath = Math.max(getPath(node.left), 0);
        int rightPath = Math.max(getPath(node.right), 0);

        int maxPath = node.val + leftPath + rightPath;

        res = Math.max(res, maxPath);
        return node.val + Math.max(leftPath, rightPath);
    }
}
