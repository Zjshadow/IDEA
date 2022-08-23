package com.zjs.Exam;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/3 20:00
 **/
public class hw_8_17_T2 {

        public static void main(String[] args) {
            Scanner sc =new Scanner(System.in);
            int len = sc.nextInt();
            int tag = sc.nextInt();
            sc.nextLine();
            //  测试 00000001000000100000000200000020000000110030000200041234567800050003abcdef
            String codeStream = sc.nextLine();
            // 消息体长度messageLen  消息体类型messageClass
            int messageLen = Integer.parseInt(codeStream.substring(16*2, 20*2), 16);
            int messageLenReal = (codeStream.length() - 40) / 2;
            int messageClass = Integer.parseInt(codeStream.substring(20*2, 22*2), 16);

            if (messageLen != messageLenReal) {
                System.out.println(-4);
            }
            else if (messageClass < 1 || messageClass > 200) {
                System.out.println(-3);
            }
            else{
                // 0~21个字节都是消息头和消息类型   从第22个开始信元
                for (int i = 22; i < len; ) {
                    int cellTag = Integer.parseInt(codeStream.substring(i*2, (i + 2)*2), 16);
                    // Tag错误，返回-2
                    if (cellTag > 65535) {
                        System.out.println(-2);
                        return;
                    }
                    int cellLen = Integer.parseInt(codeStream.substring((i + 2)*2, (i + 4)*2), 16);
                    // cellLen错误，返回-2
                    if ((i + 4 + cellLen) > len) {
                        System.out.println(-2);
                        return;
                    }
                    int cellVal = Integer.parseInt(codeStream.substring((i + 4)*2, (i + 4 + cellLen)*2), 16);
                    int cellStart = i;
                    if (tag == cellTag) {
                        System.out.println(cellStart);
                        return;
                    }
                    i += 4 + cellLen;
                }
                // 信元不存在，返回-1
                System.out.println(-1);
            }
        }
}



