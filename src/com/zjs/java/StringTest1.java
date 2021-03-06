package com.zjs.java;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * 涉及到String类与其他结构之间的转换
 */
public class StringTest1 {

    /**
     * 复习
     *    String与基本数据类型、包装类之间的转换
     *
     *    String --> 基本数据类型、包装类：调用包装类的静态方法：parseXxx(str)
     *    类似地,使用java.lang包中的Byte、Short、Long、Float、Double类调相应的类方法可以将由“数字”字符组成的字符串，
     *    转化为相应的基本数据类型。
     *    基本数据类型、包装类 --> String:调用String重载的valueOf(xxx)
     *	  相应的valueOf(byte b)、valueOf(long l)、valueOf(float f)、valueOf(doubled)、valueOf(boolean b)
     *	  可由参数的相应类型到字符串的转换
     */
    @Test
    public void test1(){
        String str1 = "123";
//        int num = (int)str1;//错误的
        int num = Integer.parseInt(str1);
        double n = Double.parseDouble(str1);

        String str2 = String.valueOf(num);   //"123
        String str3 = num + "";
        String str4 = String.valueOf(n);   //

        System.out.println(str1 == str3);   //false

        System.out.println(num);
        System.out.println(n);
        System.out.println(str4);
    }

    /**
     * String 与 byte[]之间的转换
     *
     * 编码：String --> byte[]:调用String的getBytes()
     * 解码：byte[] --> String:调用String的构造器
     *
     * 编码：字符串 -->字节  (看得懂 --->看不懂的二进制数据)
     * 解码：编码的逆过程，字节 --> 字符串 （看不懂的二进制数据 ---> 看得懂）
     *
     * 说明：解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码。
     *
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String str1 = "abc123重工";
        byte[] bytes = str1.getBytes();//使用默认的字符编码集,进行转换
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = str1.getBytes("gbk");//使用gbk字符集进行编码。
        System.out.println(Arrays.toString(gbks));

        System.out.println("*****************************");

        String str2 = new String(bytes);//使用默认的字符集，进行解码。
        System.out.println(str2);

        String str3 = new String(gbks);
        System.out.println(str3);//出现乱码。原因：编码集和解码集不一致！

        String str4 = new String(gbks,"gbk");
        System.out.println(str4);//没有出现乱码。原因：编码集和解码集一致！
    }

}