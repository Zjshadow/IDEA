package com.zjs.Exam;
import java.util.*;
/**
 * @author zjs
 * @version 1.0
 * @data 2022/9/1 20:40
 **/
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return TreeNode类一维数组
     */
    public TreeNode[] balanceSubTree (TreeNode root) {
        // write code here
        List<TreeNode> list = new ArrayList<>();
        while (isBanlanced(root)) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            boolean find = false;
            while (!queue.isEmpty()) {
                int len = queue.size();
                for (int i = 0; i < len; i++) {
                    TreeNode cur = queue.poll();
                    TreeNode l = cur.left;
                    TreeNode r = cur.right;
                    if (l == null && r == null) continue;
                    if (l != null && isBanlanced(l)) {
                        cur.left = null;
                        list.add(l);
                        find = true;
                        break;
                    }
                    if (r != null && isBanlanced(r)) {
                        cur.right = null;
                        list.add(r);
                        find = true;
                        break;
                    }
                    if (l != null) queue.add(l);
                    if (r != null) queue.add(r);
                }
                if (find) break;
            }
        }
        list.add(root);
        TreeNode[] ans = new TreeNode[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }

        Arrays.sort(ans, new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                return num(o1) - num(o2);
            }
        });

        return ans;
    }

    public boolean isBanlanced(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    public int num(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + num(node.right) + num(node.left);
    }
}