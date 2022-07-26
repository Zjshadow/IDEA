package com.zjs.IO;

import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/7/26 20:45
 **/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.nextLine();
        for (int i = 0; i < num; i++) {
            String str = in.nextLine();
            System.out.println(str);
        }
    }
}
