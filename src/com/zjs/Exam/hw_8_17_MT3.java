package com.zjs.Exam;

import java.util.Scanner;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/3 20:00
 **/
public class hw_8_17_MT3 {

        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            while(sc.hasNext()){
                String str=sc.next();
                char [] result=new char[2000];
                char [] tmp=new char[2000];
                int head1=-1,head2=-1;
                boolean flag=false;

                for (int i=0;i<str.length();i++){
                    if (head1>=0){
                        if (result[head1]==str.charAt(i)){
                            head1--;
                            tmp[++head2]=str.charAt(i);
                            flag=true;
                        }else{
                            if (head2>=0&&flag){
                                if(tmp[head2]!=str.charAt(i)){
                                    result[++head1]=str.charAt(i);
                                    flag=false;
                                }
                            }
                            else{
                                result[++head1]=str.charAt(i);
                                flag=false;
                            }
                        }
                    }
                    else{
                        result[++head1]=str.charAt(i);
                    }

                }

                for (int i=0;i<=head1;i++){
                    System.out.print(result[i]);
                }
            }
        }
}



