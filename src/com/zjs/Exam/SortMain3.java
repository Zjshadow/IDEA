package com.zjs.Exam;
import java.util.Scanner;

/**
 * 字符串数组排序,利用快排的思想
 * @author xiaobangsky
 * time:2014-10-13
 *
 */

/**
 * @author zjs
 * @version 1.0
 * @data 2022/9/9 20:32
 **/
public class SortMain3 {
    public static String[] popup(String[] stra){
        for(int i = 0; i<stra.length; i++){
            for(int k = 1; k<stra.length-1; k++){
                int a = 0;

                if(stra[k].charAt(0)>stra[k+1].charAt(0)){
                    String temp = stra[k];
                    stra[k] = stra[k+1];
                    stra[k+1] = temp;
                }
                if(stra[k].charAt(0)<stra[k+1].charAt(0)){
                    continue;
                }
                while(stra[k].charAt(a) == stra[k+1].charAt(a) && a<Math.min(stra[k].length(), stra[k+1].length())-1){
                    if(stra[k].charAt(a+1)>stra[k+1].charAt(a+1)){
                        String temp1 = stra[k];
                        stra[k] = stra[k+1];
                        stra[k+1] = temp1;
                    }else{
                        a++;
                    }
                }
                if(a == Math.min(stra[k].length(), stra[k+1].length()) && stra[k].length()>stra[k+1].length()){
                    String temp2 = stra[k];
                    stra[k] = stra[k+1];
                    stra[k+1] = temp2;
                }
                if(stra[k+1].length() == 1 && stra[k+1].charAt(0) == stra[k].charAt(0)){
                    String temp3 = stra[k];
                    stra[k] = stra[k+1];
                    stra[k+1] = temp3;
                }
            }
        }
        return stra;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] stra = new String[n+1];
        for(int i = 0; i<n+1; i++){
            stra[i] = sc.nextLine();
        }
        stra = popup(stra);
        for(int i = 1; i<stra.length; i++){
            System.out.println(stra[i]);
        }
    }
}