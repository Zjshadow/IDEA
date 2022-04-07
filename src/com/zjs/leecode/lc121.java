package com.zjs.leecode;

import org.junit.Test;

public class lc121 {
    @Test
    public void test() {
        int[] prices = new int[]{7,6,4,3,1};
        int max = maxProfit(prices);
        System.out.println(max);
    }

    public int maxProfit(int[] prices) {
        int[] pre = new int[]{0, -prices[0]};
        int[] cur = new int[2];

        for (int i = 1; i < prices.length; i++) {
            cur[0] = Math.max(pre[0], pre[1] + prices[i]);
            cur[1] = Math.max(pre[1], -prices[i]);
            pre[0] = cur[0];
            pre[1] = cur[1];
        }
        return cur[0];
    }
}
