package com.zjs.java;

public class Test3 {
    public static void main(String args[]){
        student zjs = new student();
        System.out.println(zjs.age);
        zjs.setAge(23);
        zjs.setHeight(175);
        zjs.read();
        zjs.age();
        zjs.height();
        System.out.println("end");
    }
}

class student {
    int age;
    int height;

    public void setAge(int a) {
        age =  a;
    }
    public void setHeight(int h) {
        height =  h;
    }
    public void read() {
        System.out.println("read");
    }
    public void age() {
        System.out.println(age);
    }
    public void height() {
        System.out.println(height);
    }
}
class gradute extends student {

    @Override
    public void read() {
        System.out.println("read gradute");
    }
}

interface preson{

        }