package com.zjs.leecode;

import org.junit.Test;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/6/21 15:17
 **/
public class lc148 {

    @Test
    public void test() {
        ListNode l4 = new ListNode(3);
        ListNode l3 = new ListNode(1, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(4, l2);

        ListNode res = sortList(l1);
        System.out.println(res.val);
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 寻找中点 遍历之后slow指向奇数中点，偶数偏左
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 分解
        ListNode tmp = slow.next;
        slow.next = null;    // 断开，链表分为两部分，分别处理
        // 递归分解
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        ListNode pre = new ListNode(-1);
        ListNode res = pre;

        // 合并
        while (left != null && right != null) {
            if (left.val < right.val) {
                pre.next = left;
                left = left.next;
            }
            else {
                pre.next = right;
                right = right.next;
            }
            pre = pre.next;
        }

        pre.next = left == null ? right : left;

        return res.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
