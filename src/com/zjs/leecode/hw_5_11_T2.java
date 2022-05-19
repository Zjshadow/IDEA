package com.zjs.leecode;

import java.util.*;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/5/11 22:01
 **/
public class hw_5_11_T2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        StringBuilder builder = new StringBuilder(str);
        char[] array = str.toCharArray();
        int n = 0;
        //分理出几行几列
        if (array[1]>=48&&array[1]<='9'){
            n = ((int)array[0]-'0')*10 + (int)array[1]-'0';
            builder.delete(0,2);
        }
        else{
            n = (int)array[0]-'0';
            builder.delete(0,1);
        }
        //构建矩阵
        int[][] qipan = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (builder.charAt(0)=='B'){
                    qipan[i][j] = -1;
                }
                if (builder.charAt(0)=='W'){
                    qipan[i][j] = 1;
                }
                builder.delete(0,1);
            }
        }
        System.out.println(Arrays.deepToString(qipan));

        findQi(qipan,n,1);
        int W = ans;

        ans = 0;
        System.out.println(Arrays.deepToString(qipan));
        findQi(qipan,n,-1);
        int B = ans;
        System.out.println("B "+B+" W "+W);
    }
    static int qi =0; //记录一块的气
    static int count =0; //记录一块棋子数目
    static int ans =0; //记录答案，吧所有的块加起来
    public static void findQi(int[][] qipan,int n,int Q){
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++) {
                if (qipan[i][j]==Q){
                    qi = 0;count=0;
                    helper(qipan,i,j,n,Q);
                    if (qi >= 2) {
                        ans += count;
                    }
                }
            }
        }
    }
    public static void helper(int[][] qipan,int x,int y,int n,int Q){
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return;
        }
        if (qipan[x][y]==0){
            qi++; //气加1
            return;
        }
        if (qipan[x][y] ==Q){ //白棋
            count++;
            qipan[x][y] = 9; //剪枝
            helper(qipan,x-1,y,n,Q);//向上
            helper(qipan,x+1,y,n,Q);//向下
            helper(qipan,x,y+1,n,Q);
            helper(qipan,x,y-1,n,Q);
        }
    }
}
