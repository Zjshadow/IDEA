package com.zjs.Exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/3 20:00
 **/
public class hw_8_3_T1_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int n = s.length();
        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }

        int[] res = threeEqualParts(num);
        if (res[0] == -1 && res[1] == -1) {
            System.out.println(-1);
        }
        else {
            System.out.print(s.substring(0, res[0] + 1) + " ");
            System.out.print(s.substring(res[0] + 1, res[1]) + " ");
            System.out.print(s.substring(res[1], s.length()));
        }
    }

    public static int[] threeEqualParts(int[] A) {
        int[] IMP = new int[]{-1, -1};
        int N = A.length;
        int S = 0;
        for (int x: A) S += x;
        if (S % 3 != 0) return IMP;
        int T = S / 3;
        if (T == 0)
            return new int[]{0, N - 1};
        int i1 = -1, j1 = -1, i2 = -1, j2 = -1, i3 = -1, j3 = -1;
        int su = 0;
        for (int i = 0; i < N; ++i) {
            if (A[i] == 1) {
                su += 1;
                if (su == 1) i1 = i;
                if (su == T) j1 = i;
                if (su == T+1) i2 = i;
                if (su == 2*T) j2 = i;
                if (su == 2*T + 1) i3 = i;
                if (su == 3*T) j3 = i;
            }
        }
        int[] part1 = Arrays.copyOfRange(A, i1, j1+1);
        int[] part2 = Arrays.copyOfRange(A, i2, j2+1);
        int[] part3 = Arrays.copyOfRange(A, i3, j3+1);

        if (!Arrays.equals(part1, part2)) return IMP;
        if (!Arrays.equals(part1, part3)) return IMP;

        // x, y, z: the number of zeros after part 1, 2, 3
        int x = i2 - j1 - 1;
        int y = i3 - j2 - 1;
        int z = A.length - j3 - 1;

        if (x < z || y < z) return IMP;
        return new int[]{j1+z, j2+z+1};
    }
}



