package com.zjs.leecode;

import org.junit.Test;

import java.util.*;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/6/26 22:09
 **/
public class lc297 {

    @Test
    public void test() {
        TNode n5 = new TNode(5);
        TNode n4 = new TNode(4);
        TNode n3 = new TNode(3);
        TNode n2 = new TNode(2);
        n2.left = n4;
        n2.right = n5;
        TNode n1 = new TNode(1);
        n1.left = n2;
        n1.right = n3;
        Codec ser = new Codec();
        Codec deser = new Codec();
        TNode ans = deser.deserialize(ser.serialize(n1));
    }

}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TNode {
    int val;
    TNode left;
    TNode right;
    TNode(int x) { val = x; }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TNode root) {
        if (root == null)
            return "N,";
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + right;
    }

    // Decodes your encoded data to tree.
    public TNode deserialize(String data) {
        String[] str = data.split(",");
        Deque<String> strDeque = new LinkedList<>(Arrays.asList(str));
        return buildTree(strDeque);
    }

    public TNode buildTree(Deque<String> deque) {
        String cur = deque.poll();
        if (cur.equals("N"))
            return null;

        TNode node = new TNode(Integer.valueOf(cur));
        node.left = buildTree(deque);
        node.right = buildTree(deque);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));