package com.zjs.leecode;

import java.util.Scanner;

public class gld_5_25_test{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int left = sc.nextInt();
            int right = sc.nextInt();

            int flag = 1;
            for (int i = left; i <= right; i++) {
                int a = i/100;//获取百位
                int b = (i%100)/10;//获取十位
                int c = i%10;//获取个位
                if(i==a*a*a+b*b*b+c*c*c){
                    if (flag == 1)
                        System.out.print(i);
                    else
                        System.out.print(" " + i);
                    flag = 0;
                }
            }
            if (flag == 1)
                System.out.print("no");
            System.out.println();
        }

//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int num = sc.nextInt();
//            int cnt = sc.nextInt();
//            double res = num;
//            double tmp = num;
//            for (int i = 0; i < cnt - 1; i++) {
//                tmp = Math.sqrt(tmp);
//                res += tmp;
//            }
//            System.out.format("%.2f%n",res);
//        }
    }
}
