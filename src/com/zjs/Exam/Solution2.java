package com.zjs.Exam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/9/1 20:40
 **/
public class Solution2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return TreeNode类一维数组
     */
    public TreeNode[] balanceSubTree (TreeNode root) {
        // write code here
        TreeNode[] ans = new TreeNode[]{root};
        List<TreeNode> res = new ArrayList<>();
        Queue<TreeNode> queueTree = new LinkedList<>();
        queueTree.offer(root);
        while (!queueTree.isEmpty()) {
            int len = queueTree.size();
            while (len > 0) {
                TreeNode cur = queueTree.poll();
                if (isBanlanced(cur)) {
                    res.add(cur);
                    break;
                }
                if (cur.left != null) {
                    queueTree.offer(cur.left);
                }
                if (cur.right != null) {
                    queueTree.offer(cur.right);
                }
                len--;
            }
        }

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
}