package com.zjs.Exam;

import java.util.HashMap;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/3 15:54
 **/
public class zijie_8_3_1M {
    public static void main(String[] args) {
//        int[] nums = new int[]{-3, -3, 0, 1, 2, 3, 3, 3};
        int[] nums = new int[]{-3, -3, 0, 1, 2, 3, 3};
        System.out.println(twosum(nums, 0));
    }

    public static int twosum(int[] nums, int tar) {
        HashMap<Integer, Integer> set = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            set.put(nums[i], set.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            int tmp = tar - nums[i];
//            if (set.containsKey(tmp)) {
//                if (set.get(tmp) != nums[i]) {
//                    ans += set.get(tmp);
//                }
//            }
            if(tmp == nums[i] && set.containsKey(tmp)){
                ans = ans + set.get(tmp) -1; //0
            }else if (set.containsKey(tmp)){
                ans = ans + set.get(tmp) ; // 非0
            }
        }
        return  ans/2;
    }
}
