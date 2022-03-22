package com.zjs.leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class lc94 {

    @Test
    public void  test() {
//        List<Integer> ans = inorderTraversal(root);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        inorder(root, ans);
        return ans;
    }

    public void inorder(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;

        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }

}

