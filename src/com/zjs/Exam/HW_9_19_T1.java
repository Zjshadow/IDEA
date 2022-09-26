package com.zjs.Exam;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/9/19 11:02
 **/
public class HW_9_19_T1 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        int i = 0;
        int j = nums.length - 1;
        int ans = 0;
        while ( i < j) {
            if (nums[i] < nums[j]) {
                ans = Math.max(ans, (j - i)*nums[i++]);
            }
            else {
                ans = Math.max(ans, (j - i) * nums[j--]);
            }
        }

        System.out.println(ans);
    }
}
