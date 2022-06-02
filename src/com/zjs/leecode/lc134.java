package com.zjs.leecode;

import org.junit.Test;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/6/1 15:12
 **/
public class lc134 {
    public static void main(String[] args) {

    }

    @Test
    public void test() {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};

        int res = canCompleteCircuit(gas, cost);
        System.out.println(res);
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int curGas = gas[i];
            int start = i;

            while (curGas >= cost[start]) {
                int next = (start+1) % n;
                curGas = curGas - cost[start] + gas[next];
                start = next;
                if (next == i)
                    return i;
            }

        }

        return -1;
    }
}
