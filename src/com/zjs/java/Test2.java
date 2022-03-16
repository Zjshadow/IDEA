package com.zjs.java;

public class Test2 {
    public static void main(String args[]) {
        double[] a = new double[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = Math.random() * 90 + 10;
            System.out.println(a[i]);
        }
    }
}
