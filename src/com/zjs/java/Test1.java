package com.zjs.java;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入2020年的month");
        int month = scan.nextInt();
        System.out.println("请输入2020年的day");
        int day = scan.nextInt();

        //定义一个变量来保存天数
        int sumDays = 0;
        switch(month){
            case 12:
                sumDays += 30;
                System.out.println("进入12");
            case 11:
                sumDays += 31;
                System.out.println("进入11");
            case 10:
                sumDays += 30;
                System.out.println("进入10");
            case 9:
                sumDays += 31;
                System.out.println("进入9");
            case 8:
                sumDays += 31;
                System.out.println("进入8");
            case 7:
                sumDays += 30;
                System.out.println("进入7");
            case 6:
                sumDays += 31;
                System.out.println("进入6");
            case 5:
                sumDays += 30;
                System.out.println("进入5");
            case 4:
                sumDays += 31;
                System.out.println("进入4");
            case 3:
                sumDays += 29;
                System.out.println("进入3");
            case 2:
                sumDays += 31;
                System.out.println("进入2");
            case 1:
                sumDays += day;
                System.out.println("进入1");
        }

        System.out.println("2020年" + month + "月" + day + "日是当年的第" + sumDays + "天");
}
}