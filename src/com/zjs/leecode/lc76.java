package com.zjs.leecode;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/7/8 11:19
 **/
public class lc76 {
    @Test
    public void test() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = minWindow(s, t);
        System.out.println(res);
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> wind = new HashMap<>();
        char[] charT = t.toCharArray();
        char[] charS = s.toCharArray();
        for (char c : charT) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        // 窗口左右指针 左开右闭
        int left = 0, right = 0;
        // 记录窗口是否满足t字符要求
        int valid = 0;
        // 记录最小覆盖子串的起点以及长度
        int start = 0, len = Integer.MAX_VALUE;

        while (right < s.length()) {
            // 移入窗口
            char c = charS[right];
            // 扩大窗口
            right++;
            // 窗口内数据更新
            if (need.containsKey(c)) {
                wind.put(c, wind.getOrDefault(c, 0) + 1);
                if (wind.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                // 更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // 移出窗口
                char d = charS[left];
                // 缩小窗口
                left++;
                // 窗口内数据更新
                if (need.containsKey(d)) {
                    if (wind.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    wind.put(d, wind.get(d) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
    }