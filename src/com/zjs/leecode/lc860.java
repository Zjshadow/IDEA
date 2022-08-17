package com.zjs.leecode;

import org.junit.Test;

public class lc860 {
    public static void main(String[] args) {

    }

    @Test
    public void test() {
        int[] bills = {5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};
        boolean res = lemonadeChange(bills);
        System.out.println(res);
    }



    public boolean lemonadeChange(int[] bills) {
        // 只需要保存5美元和10美元的数量
        int[] money = new int[2];
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                money[0]++;
            }
            else if (bills[i] == 10) {
                if (money[0] != 0) {
                    money[0]--;
                    money[1]++;
                }
                else {
                    return false;
                }
            }
            else {
                // 错解[5,5,10,10,20]
                if (money[0] != 0 && money[0] * 5 + money[1] * 10 >= 15) {
                    money[0]--;
                    money[1]--;
                }
                else {
                    return false;
                }

            }
        }

        return true;
    }
}
