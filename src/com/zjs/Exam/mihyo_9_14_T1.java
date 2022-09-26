package com.zjs.Exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/9/14 19:46
 **/
public class mihyo_9_14_T1 {
    public static void main(String[] args) {
        List<Integer> idxList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int start = 0;
        int end = 0;
        int minDis = Integer.MAX_VALUE;
        sc.nextLine();
        String str = sc.nextLine();

        int left = 0;
        int right = left + 6;
        while (right <= str.length()) {
            if (isSame(str, left, "mihoyo")) {
                idxList.add(left);
//                System.out.println(left);
                left += 6;
                right += 6;
            }
            else {
                left++;
                right++;
            }
        }
        if (k > idxList.size()) {
            System.out.println(-1);
        }
        else {
            for (int i = 0; i < idxList.size() - k + 1; i++) {
                int s = idxList.get(i);
                int e = idxList.get(i + k - 1) + 5;
                if (e - s < minDis) {
                    start = s;
                    end = e;
                    minDis = e - s;
                }
            }
            System.out.println(start + " " + end);
        }
    }

    public static boolean isSame(String strOri, int idx, String strTar){
        return strOri.substring(idx, idx + 6).equals(strTar);
    }
}
