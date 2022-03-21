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
    }

//   二维数组

    public int weightBagProblem(int[] weight, int[] value, int bagSize){
        int[][] dp = new int[weight.length][bagSize + 1];

        for (int j = weight[0]; j <= bagSize; j++) {
            dp[0][j] = value[0];
        }

        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j < bagSize + 1; j++) {
                if (j < weight[i])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
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

//    一维数组
    public int weightBagProblem2(int[] weight, int[] value, int bagSize){
        int[] dp = new int[bagSize + 1];
//        默认初始化为0

        for (int i = 0; i < weight.length; i++) {
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

        //打印dp数组
        for (int j = 0; j <= bagSize; j++){
            System.out.print(dp[j] + " ");
        }
        System.out.print("\n");
        return dp[bagSize];

    }
}
