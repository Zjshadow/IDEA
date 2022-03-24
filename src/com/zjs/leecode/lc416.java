package com.zjs.leecode;

import org.junit.Test;

public class lc416 {

    @Test
    public void test(){
        int[] nums = {1,5,11,5};
        System.out.println(canPartition(nums));
    }


    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 如果和为奇数，则不可能分割为等和子集
        if (sum % 2 == 1)   return false;
        int target = sum/2;

        // DP数组
        int[] dp = new int[target + 1];
        for (int i = 0; i < n; i++) {
            for (int j = target; j >= 0; j--) {
                if (j < nums[i])
                    dp[j] = dp[j];
                else
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        if (dp[target] == target)
            return true;
        return false;
    }

}
