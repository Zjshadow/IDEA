package com.zjs.Exam;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/13 15:58
 **/
public class Main_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        LinkedList<Integer> tmp = new LinkedList<>();
        int tmpNum = 0;
        tmp.addLast(nums[n - 1]);
        for (int i = 2; i <= n; i++) {
            tmpNum = tmp.removeLast();
            tmp.addFirst(tmpNum);
            tmpNum = tmp.removeLast();
            tmp.addFirst(tmpNum);
            tmp.addFirst(nums[n - i]);
        }
        tmpNum = tmp.removeLast();
        tmp.addFirst(tmpNum);
        tmpNum = tmp.removeLast();
        tmp.addFirst(tmpNum);
        for (int i = 0; i < tmp.size() - 1; i++) {
            System.out.print(tmp.get(i) + " ");
        }
        System.out.print(tmp.get(tmp.size() - 1));
    }
}
