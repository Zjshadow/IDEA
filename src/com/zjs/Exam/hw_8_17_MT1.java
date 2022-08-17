package com.zjs.Exam;

import java.util.Scanner;

public class hw_8_17_MT1 {

    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);
        int n,sum;
        System.out.print("请输入一个整数：");
        n=input.nextInt();
        boolean flag = false;//用于不符合输出提示信息

        for(int i=1;i<=n/2+1;i++){   //从1--n/2+1数逐一尝试是否满足要求，满足则输出
            sum=0;
            if (flag == true) {
                break;
            }
            for(int j=i;j<=n/2+1;j++){   //从上一个循环的首位数字连续累加
                sum=sum+j;
                if(sum==n&&sum!=j){     //满足条件n(n>=2)个连续整数相加
                    System.out.println("Yes");
                    flag=true;
                    break;
                }
            }
        }
        if(!flag)   //没有满足条件
            System.out.println("No");
    }
}
