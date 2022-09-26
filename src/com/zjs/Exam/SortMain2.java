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
public class SortMain2 {
    static Scanner scan = new Scanner(System.in);
    public static void quickSort(String[] pData,int left,int right)
    {
        int i,j;
        String first,temp;
        i = left;
        j = right;
        first = pData[left]; //这里选其他的数也行，不过一般选第一个
        //一趟快速排序
        while(true)
        {
            //从第二个数开始找大于中枢的数 ,从前面开始找大于pData[left]的数
            while((++i)<right-1 && pData[i].compareTo(first)<0);
            //从最后一个数开始找第一个小于中枢pData[left]的数
            while((--j)>left && pData[j].compareTo(first)>0);
            if(i>=j)
                break;
            //交换两边找到的数
            temp = pData[i];
            pData[i] = pData[j];
            pData[j] = temp;

        }
        //交换中枢
        pData[left] = pData[j];
        pData[j] = first;
        //递归快排中枢左边的数据
        if(left<j)
            quickSort(pData,left,j);
        //递归快排中枢右边的数据
        if(right>i)
            quickSort(pData,i,right);
    }

    public static void main(String[] args) {
        String str = scan.next();
        String[] arr = str.split("\\,");
        quickSort(arr, 0, arr.length);
        int i;
        for(i=0;i<arr.length-1;i++) {
            System.out.print(arr[i]+",");
        }
        System.out.println(arr[i]);
    }
    }