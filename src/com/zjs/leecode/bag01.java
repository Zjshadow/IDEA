package com.zjs.leecode;
import org.junit.Test;


public class bag01 {

    @Test
    public void test(){

        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;

        int ans = weightBagProblem(weight, value, bagSize);
        System.out.println(ans);

        int ans2 = weightBagProblem2(weight, value, bagSize);
        System.out.println(ans2);

        int ans3 = weightBagProblem3(weight, value, bagSize);
        System.out.println(ans3);

        int ans4 = weightBagProblem4(weight, value, bagSize);
        System.out.println(ans4);
    }

//   二维数组   01背包
    public int weightBagProblem(int[] weight, int[] value, int bagSize){
        int[][] dp = new int[weight.length][bagSize + 1];

        for (int j = weight[0]; j <= bagSize; j++) {
            dp[0][j] = value[0];
        }

        //  weight和bagSize的两次for循环的内外顺序可以颠倒
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j < bagSize + 1; j++) {
                if (j < weight[i])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
            }
        }

        // 测试下从后向前  正常无误  因为根据递推关系，dp[i][j]只与上一行dp[i - 1][X]相关
//        for (int i = 1; i < weight.length; i++) {
//            for (int j = bagSize; j >= 1; j--) {
//                if (j < weight[i])
//                    dp[i][j] = dp[i - 1][j];
//                else
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
//                System.out.println(dp[i][j]);
//            }
//        }
        //打印dp数组
        for (int i = 0; i < weight.length; i++){
            for (int j = 0; j < bagSize + 1; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }

        return dp[weight.length - 1][bagSize];

    }

//    一维数组  01背包
    public int weightBagProblem2(int[] weight, int[] value, int bagSize){
        int[] dp = new int[bagSize + 1];
        //  默认初始化为0
        //  for循环顺序不可以颠倒
        for (int i = 0; i < weight.length; i++) {
            // 必须从后向前遍历
            for (int j = bagSize; j >= 0; j--) {
                if (j < weight[i])
                    dp[j] = dp[j];
                else
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
            //内部打印一维dp数组更新
            for (int j = 0; j <= bagSize; j++){
                System.out.print(dp[j] + " ");
            }
            System.out.print("\n");
        }
        return dp[bagSize];
    }

    //    一维数组  完全背包
    public int weightBagProblem3(int[] weight, int[] value, int bagSize){
        int[] dp = new int[bagSize + 1];
        //  默认初始化为0
        //  for循环顺序可以颠倒
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j <= bagSize; j++) {
                if (j < weight[i])
                    dp[j] = dp[j];
                else
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
            //内部打印一维dp数组更新
            for (int j = 0; j <= bagSize; j++){
                System.out.print(dp[j] + " ");
            }
            System.out.print("\n");
        }
        return dp[bagSize];
    }

    //    二维数组  完全背包
    public int weightBagProblem4(int[] weight, int[] value, int bagSize){
        int[][] dp = new int[weight.length][bagSize + 1];
        //  注意初始化区别于01背包问题中的二维数组
        for (int j = weight[0]; j <= bagSize; j++) {
            dp[0][j] = (j / weight[0]) * value[0];
        }
        //  for循环顺序可以颠倒
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i])
                    dp[i][j] = dp[i - 1][j];
                else {
                    // 注意递推公式区别于01背包中的二维数组
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weight[i]] + value[i]);
                }
            }
        }

        //打印dp数组
        for (int i = 0; i < weight.length; i++){
            for (int j = 0; j < bagSize + 1; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
        return dp[weight.length - 1][bagSize];
    }
}
