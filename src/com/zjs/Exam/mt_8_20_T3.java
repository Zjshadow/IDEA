package com.zjs.Exam;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class mt_8_20_T3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        double ans = 0.0;

        int[] prob = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] scores = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        double[][] tmp = new double[n][2];
        for (int i = 0; i < n; i++) {
            tmp[i][0] = prob[i] * 0.01 * scores[i];
            tmp[i][1] = (100 - prob[i]) * 0.01 * scores[i];
        }

        Arrays.sort(tmp, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if (o1[1] == o2[1]) {
                    return (int) (o2[0] - o1[0]);
                }
                return (int) (o2[1] - o1[1]);
            }
        });
        for (int j = 0; j < n; j++) {
            System.out.println(tmp[j][0]);
            System.out.println(tmp[j][1]);
        }
        for (int j = 0; j < n; j++) {
            if (j < m) {
                ans += tmp[j][1] + tmp[j][0];
            }
            else {
                ans += tmp[j][0];
            }
        }

        System.out.printf("%.2f", ans);
    }
}
