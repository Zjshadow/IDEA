package com.zjs.leecode;
import org.junit.Test;

import java.util.Arrays;

public class lc136 {

    @Test
    public void test() {
        int[] n = new int[] {1, 2, 2, 4, 4};
        int ans = singleNumber(n);
        System.out.println(ans);
    }

    public int singleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i ++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("");
        if ((n == 1) || (nums[0] != nums[1]))
            return nums[0];

        int idx = 1;
        while(idx < n) {
            if (nums[idx] != nums[idx - 1])
                break;
            else
                idx = idx + 2;
        }

        if (idx >= n)
            return nums[n - 1];

        return nums[idx - 1];
    }
}
