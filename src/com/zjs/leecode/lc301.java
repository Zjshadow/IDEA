package com.zjs.leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/6/28 17:45
 **/
public class lc301 {
    @Test
    public void test(){
        String s = "()())()";
        List<String> ans = removeInvalidParentheses(s);
    }

    HashSet<String> res = new HashSet<>();
    int maxSorce = 0;
    int len = 0;
    public List<String> removeInvalidParentheses(String s) {
        int l = 0, r = 0;
        int leftNum = 0, rightNum = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                l++;
                leftNum++;
            }
            else if (c == ')') {
                if (l > 0) {
                    l--;
                }
                else{
                    r++;
                }
                rightNum++;
            }
        }

        len = n - l - r;
        maxSorce = Math.min(leftNum, rightNum);
        backtracking(s, l, r, 0, 0, "");

        return new ArrayList<>(res);
    }


    public void backtracking(String s, int l, int r, int idx, int score, String cur) {
        if (l < 0 || r < 0 || score < 0 || score > maxSorce)	return;
        if (l == 0 && r == 0) {
             if (cur.length() == len)
                 res.add(cur);
        }
        if (idx == s.length())	return;

        char c = s.charAt(idx);
        if (c == '(') {
            // 左括号加入结果
            backtracking(s, l, r, idx+1, score+1, cur+String.valueOf(c));
            // 左括号忽略
            backtracking(s, l-1, r, idx+1, score, cur);
        }
        else if (c == ')') {
            // 右括号加入结果
            backtracking(s, l, r, idx+1, score-1, cur+String.valueOf(c));
            // 右括号忽略
            backtracking(s, l, r-1, idx+1, score, cur);
        }
        else {
            backtracking(s, l, r, idx+1, score, cur+String.valueOf(c));
        }
    }

}
