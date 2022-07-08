package com.zjs.leecode;

import org.junit.Test;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/7/3 23:06
 **/
public class lc10 {
    @Test
    public void test() {
        String s = "aa";
        String p = "a*";
        System.out.println(isMatch(s, p));

    }

    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        char[] charS = s.toCharArray();
        char[] charP = p.toCharArray();
        // dp[i][j]代表s的0-i个字符串和p的0-j个字符串是否匹配
        boolean[][] dp = new boolean[sLen+1][pLen+1];

        // 初始化
        //s为空,p为空时,一定匹配
        dp[0][0] = true;
        //s为空,p不为空时
        for (int i = 2; i <= pLen; i++) {
            if (charP[i - 1] == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        // 递推过程
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (charS[i - 1] == charP[j - 1] || charP[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if (charP[j - 1] == '*') {
                    if (charS[i - 1] == charP[j - 2] || charP[j - 2] == '.') {
                        // charS[i - 1] == charP[j - 2],charP[j - 1]这一个*符号可以将charP[j - 2]匹配0次、1次或者N次
                        dp[i][j] = (dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j]);
                    }
                    else {
                        // charS[i - 1] != charP[j - 2],charP[j - 1]这一个*符号只能将charP[j - 2]匹配0次
                        dp[i][j] = dp[i][j - 2];
                    }
                }
                // charS[i - 1]与charP[j - 1]无法匹配且charP[i - 1] != '*'的其他情况，默认为false
            }
        }

        return dp[sLen][pLen];

    }
}