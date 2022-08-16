package com.zjs.Exam;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/3 14:40
 **/
public class wl_8_3_1M {
    public static void main(String[] args) {
        int[] nums = new int[]{9,4,7,2,10};
        System.out.println(longestArithSeqLength(nums));
    }

    public static int longestArithSeqLength(int[] nums) {

        int n=nums.length;
        int[][] dp=new int[n][1001];
        int maxLen=0;//保存结果
        for(int k=1;k<n;k++){
            for(int j=0;j<k;j++){
                int d=nums[k]-nums[j]+500;//统一加偏移量，使下标非负
                dp[k][d]=dp[j][d]+1; //根据 d 去填充dp[k][d]
                maxLen=Math.max(maxLen,dp[k][d]);//维护最大值
            }
        }
        return maxLen+1;
    }
}
