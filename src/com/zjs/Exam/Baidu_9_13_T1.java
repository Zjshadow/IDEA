package com.zjs.Exam;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/9/13 19:42
 **/
public class Baidu_9_13_T1 {
    static HashSet<Character> yunyin = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        yunyin.add('a');
        yunyin.add('e');
        yunyin.add('i');
        yunyin.add('o');
        yunyin.add('u');
        int left = 0, right = 5;
        int ans = 0;

        while (right < in.length()) {
            if (isWorld(in, left, right)) {
                left++;
                right++;
                ans++;
            }
            else {
                left++;
                right++;
            }
        }

        System.out.println(ans);

    }

    public static boolean isWorld(String str, int left, int right) {
        boolean ans = false;
        Character charOne = str.charAt(left);
        if (!yunyin.contains(charOne)) {
            Character charFive = str.charAt(left + 3);
            if (!yunyin.contains(charFive) && !charFive.equals(charOne)) {
                Character charTwo = str.charAt(left + 1);
                if (yunyin.contains(charTwo)) {
                    Character charThree = str.charAt(left + 2);
                        if (yunyin.contains(charThree) &&  !charThree.equals(charTwo)){
                            Character charFour = str.charAt(left + 4);
                            if (yunyin.contains(charFour) &&  !charFour.equals(charThree) && !charFour.equals(charTwo)){
                                ans = true;
                            }
                    }
                }
            }
        }
        return ans;
    }
}
