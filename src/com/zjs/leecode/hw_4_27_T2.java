package com.zjs.leecode;

import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/4/27 19:34
 **/
public class hw_4_27_T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        while (m!=0){
            String next = scanner.next();
            String[] strings = next.split("\\*");
            String[] str2 = strings[1].split("=");
            int a = Integer.parseInt(strings[0]);
            int b = Integer.parseInt(str2[0]);
            int c = Integer.parseInt(str2[1]);
            //a*b
            long sum = a*b;
            String ans = a + "*" + b + "=" + sum;
            int result = minDis(ans, next);
            //c/b
            if (c%b==0){
                String ans1 = (int) (c / b) + "*" + b + "=" + c;
                int min1 = minDis(ans1, next);
                if (result==-1||min1==-1)
                    result = Math.max(result,minDis(ans1, next));
                else
                    result = Math.min(result,minDis(ans1, next));
            }
            //c/a
            if (c%a==0){
                String ans2 = a + "*" + (int)(c/a) + "=" + c;
                int min2 = minDis(ans2, next);
                if (result==-1||min2==-1)
                    result = Math.max(result,minDis(ans2, next));
                else
                    result = Math.min(result,minDis(ans2, next));
            }
            System.out.println(result);
            m--;
        }
    }

    public static int minDis(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 != len2)
            return -1;
        int count = 0;
        for (int i = 0; i < len1; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
        }

        return count;
    }
}
