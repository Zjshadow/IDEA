package com.zjs.leecode;

import java.util.*;

public class Solution {
    public static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        res =  restoreIpAddresses(str);
        System.out.println(res);
    }

    public static List<String> restoreIpAddresses(String s) {
        backtracking(s, 0, 0);
        return res;
    }

    // 递归函数
    public static void backtracking(String s, int idx, int pointNum) {
        // 终止条件
        if (pointNum == 3) {
            if (isValid(s, idx, s.length() - 1))
                res.add(s);
            return;
        }

        // 单层搜索过程
        for (int i = idx; i < s.length(); i++) {
            if (isValid(s, idx, i)){
                //插入分隔符.
                s = s.substring(0, i + 1) + '.' + s.substring(i + 1);
                pointNum++;
                backtracking(s, i+2, pointNum);     //注意是从i+2继续开始下一次切割，因为中间加了分割符
                pointNum--;
                s = s.substring(0, i + 1) + s.substring(i + 2);
            }
            else{
                // 这里和之前不一样，不是continue，因为后续再往后尝试切割一定是不合法，所以直接结束本层循环
                break;
            }
        }
    }

    // 判断[start, end]区间数字是否合法
    public static boolean isValid(String s, int start, int end) {
        if (start > end)
            return false;

        // 以0开头不合法
        if (s.charAt(start) == '0' && start != end)
            return false;

        int num = 0;
        for (int i = start; i <= end; i++) {
            // 遇到非数字字符不合法
            if (s.charAt(start) < '0' || s.charAt(end) > '9')
                return false;
            // 判断是否大于255
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255)
                return false;
        }

        return true;
    }
}