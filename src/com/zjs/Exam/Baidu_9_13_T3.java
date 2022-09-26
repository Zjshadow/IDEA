package com.zjs.Exam;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/9/13 19:42
 **/
public class Baidu_9_13_T3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = 0;
        LinkedList<Character> stack = new LinkedList<>();
        while (sc.hasNext()) {
            String str = sc.nextLine();
            if (str.contains("for")) {
                stack.push('f');
            }
            if (str.contains("{")){
                if (!stack.isEmpty() && (stack.peek() == 'f' || stack.peek() =='{')) {
                    stack.push('{');
                }
            }
            if (str.contains("}")) {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() == 'f') {
                    stack.pop();
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
