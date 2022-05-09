package com.zjs.leecode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/4/17 15:59
 **/
public class test1 {
    static int maxx;
    static boolean bao_flag;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        while (num != 0) {
            maxx = -1;
            bao_flag = true;

            int shuju = scanner.nextInt();
            int[][] array = new int[shuju][3];
            for (int i = 0; i < shuju; i++) {
                for (int j = 0; j < 3; j++) {
                    array[i][j] = scanner.nextInt();
                }
            }

            //排序，第一列从小到大排序；第二列从大到小排序,第三列从大到小排序
            Arrays.sort(array, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0] && o1[1] == o2[1]) {  //排序第三列
                        return o2[2] - o1[2];
                    }
                    if (o1[0] == o2[0]) {  //排序第二列
                        return o2[1] - o1[1];
                    }
                    return (o1[0] - o2[0]);   //排第一列
                }
            });

            //满足暴击概率达到100，并且使得最高的
            helper(array, shuju);
            //暴击率不够
            if (bao_flag == false) {
                System.out.println("TAT");
            } else {
                System.out.println(maxx);
            }
            num--;
        }
    }

    public static void helper(int[][] array,int shuju){
        //选择出暴击概率达标并且伤害最高的
//        System.out.println(Arrays.deepToString(array));
        //计算暴击率能否达到100
        int BaoJiLv = 0;
        for (int i = 0; i < shuju; i++) {
            if (i == 0) {
                BaoJiLv += array[i][1];
            }
            if (i!=0 && array[i][0]!=array[i-1][0])
                BaoJiLv += array[i][1];
        }
        if (BaoJiLv <100){
            bao_flag = false;
            return;
        }
        //暴击率能到100的前提下,回溯
        int yuhunnum = array[shuju-1][0];
        jisuan(array,0,1,0,0,shuju,yuhunnum);

    }

    public static void jisuan(int[][] array,int p,int num,int baosum,int sum,int shuju,int yuhunnum){
        if (num==(yuhunnum+1) && baosum>=100){
            maxx = Math.max(maxx,sum);
            return;
        }
        //找到开头和结尾
        int start =-1 ;int end= -2;
        for (int i = p; i < shuju; i++) {
            if (array[i][0]==num && start==-1){
                start = i;
            }
            if (array[i][0]==num){
                end = i;
            }
        }
        //递归遍历
        for (int i = start; i <= end; i++) {
            jisuan(array,i+1,num+1,baosum+array[i][1],sum+array[i][2],shuju,yuhunnum);
        }
    }
}