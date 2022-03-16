package com.zjs.java;

public class Test {
    public static void main(String args[]) {
        Test test = new Test();
        test.first();
    }
    public void first() {
        int i = 5;
        Value v = new Value();
        v.i = 25;
        second(v, i);
        System.out.println(v.i);
    }
    public void second(Value v, int i) {
        i = 0;
        v.i = 20;
        Value val = new Value();
        v = val;
        System.out.println(v.i + " " + i);
    } }
class Value {
    int i = 15;
}

interface A {
    int x = 0;
}
class B {
    int x = 1;
}
