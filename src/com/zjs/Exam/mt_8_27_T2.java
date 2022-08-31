package com.zjs.Exam;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/13 15:58
 **/
public class mt_8_27_T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int step = sc.nextInt();
        LinkedList<Integer> stack = new LinkedList<>();
        LinkedHashSet<Integer> nums = new LinkedHashSet<>();

        int[] numT = new int[step];
        for (int i = 0; i < step; i++) {
            numT[i] = sc.nextInt();
        }
        for (int i = step - 1; i >= 0; i--) {
            if (nums.contains(numT[i])) {
                continue;
            }
            stack.addFirst(numT[i]);
            nums.add(numT[i]);
        }

        for (int i = stack.size() - 1; i >= 0; i--) {
            if (nums.size() == n && i == 0) {
                System.out.print(stack.get(i));
                return;
            }
            System.out.print(stack.get(i) + " ");
        }

        for (int i = 1; i <= n; i++) {
            if (!nums.contains(i)) {
                if (i == n) {
                    System.out.print(i);
                    return;
                }
                System.out.print(i + " ");
            }
        }
    }
}
