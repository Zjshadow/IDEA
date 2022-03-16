package com.zjs.java;

class C extends B implements A {
    public void pX() {
//		编译不通过，x 不明确
//        System.out.println(x);
		System.out.println(super.x); //1
		System.out.println(A.x);//0
    }
    public static void main(String[] args) {
        new C().pX();
    }
}