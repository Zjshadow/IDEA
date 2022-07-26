package com.zjs.java;

public class Test {
    public static void main(String args[]) {
        testMT();
    }

    static void testRun(){
        System.out.print("world");
    }

    public static void testMT(){
        Thread t = new Thread() {
            @Override
            public void run(){
                testRun();
            }
        };

        t.start();
        System.out.print("hello");
    }
}
