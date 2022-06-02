package com.zjs.leecode;

import org.junit.Test;

import java.util.function.DoubleToIntFunction;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/6/2 19:43
 **/
public class lc135 {
    public static void main(String[] args) {

    }
    @Test
    public void test() {
        int[] ratings = new int[]{1,0,2,2,2,2,2,2};
        int res = candy(ratings);
        System.out.println(res);
    }


    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] sweet = new int[n];
        int sNum = 0;

        sweet[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                sweet[i] = sweet[i - 1] + 1;
            }
            else {
                sweet[i] = 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                sweet[i] = Math.max(sweet[i], sweet[i + 1] + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            sNum += sweet[i];
        }
        return sNum;
    }
}
