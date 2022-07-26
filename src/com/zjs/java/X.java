package com.zjs.java;

import javax.print.DocFlavor;
import java.text.NumberFormat;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/7/9 19:15
 **/
public class X {
    private static int a;

    public static void main(String[] args) {
        modify(a);
        System.out.println(a);
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(4);
        nf.setMinimumFractionDigits(2);

    }

    public static void modify(int a) {
        a++;
    }
}
