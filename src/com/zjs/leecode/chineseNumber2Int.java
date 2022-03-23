package com.zjs.leecode;

import org.junit.Test;

import java.util.*;

public class chineseNumber2Int {

    public static void main(String[] args){
        System.out.println("test");
    }
    HashMap<Character, Long> nummap;
    HashMap<Character, Long> map;

    @Test
//    化磊解法  未修改完毕   目前问题在于亿会累乘万，导致错误
    public void test3(){
        nummap = new HashMap<>();
        nummap.put('一',1L);nummap.put('二',2L);nummap.put('三',3L);
        nummap.put('四',4L);nummap.put('五',5L);nummap.put('六',6L);
        nummap.put('七',7L);nummap.put('八',8L);nummap.put('九',9L);
        map = new HashMap<>();
        map.put('十',10L);map.put('百',100L);map.put('千',1000L);map.put('万',10000L);
        map.put('亿',100000000L);

//        String[] s1 = "一亿零五万零五百零二亿一千二百三十四万一千零五".split("亿");
//        String[] s1 = "十亿零五万零五百零二亿一千二百三十四万一千零五".split("亿");
//        String[] s1 = "一百零五亿一千二百三十四万一千七百零五".split("亿");
//        String[] s1 = "十".split("亿");
        long ans = 0L;
//        for (int i = 0; i < s1.length; i++) {
//            System.out.println(zhToala(s1[i].toCharArray()));
//            ans += zhToala(s1[i].toCharArray())*Math.pow(100000000L,(s1.length-i-1));
//        }
        String s1 = "一百零五亿一千二百三十四万一千七百零五";
        ans = zhToala(s1.toCharArray());
        System.out.println(ans);
    }

    public long zhToala(char[] nums){
        //判0
        if (nums.length==0){
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                if (nums[i]=='十'||nums[i]=='百'||nums[i]=='千'){
                    //千百十
                    if (stack.isEmpty())
                        ans += 10;
                    else {
                        Character pop = stack.pop();
                        ans += nummap.get(pop)*map.get(nums[i]);
                    }
                }
                else if (nums[i]=='万'){
                    //万
                    if (stack.isEmpty()) {
                        ans *= map.get(nums[i]);
                    }
                    else {
                        Character pop = stack.pop();
                        ans += nummap.get(pop);
                        ans *= map.get(nums[i]);
                    }
                }
                else {
                    //亿
                    if (stack.isEmpty()) {
                        ans *= map.get(nums[i]);
                    }
                    else {
                        Character pop = stack.pop();
                        ans += nummap.get(pop);
                        ans *= map.get(nums[i]);
                    }
                }
            }
            else if (nums[i]!='零'){
                stack.push(nums[i]);
            }
        }
        if (!stack.isEmpty()){
            Character pop = stack.pop();
            ans +=  nummap.get(pop);
        }
        return ans;
    }

    @Test
    public void test2(){
        Map<Character, String> numberMap = new HashMap<Character, String>();
        numberMap.put('零', "0");
        numberMap.put('一', "1");
        numberMap.put('二', "2");
        numberMap.put('三', "3");
        numberMap.put('四', "4");
        numberMap.put('五', "5");
        numberMap.put('六', "6");
        numberMap.put('七', "7");
        numberMap.put('八', "8");
        numberMap.put('九', "9");
        Map<Character, String> numberBit = new HashMap<Character, String>();
        numberBit.put('十', "10");
        numberBit.put('百', "100");
        numberBit.put('千', "1000");
        numberBit.put('万', "10000");
        /**
         * 思路：循环遍历数字字符数组
         *       举例：
         *       九                                    把numberMap的key为九取出， 即9
         *       九十                               把numberMap的key为九取出并乘以numberBit的key为十的值，即9*10=90
         *       九十一                          把numberMap的key为九取出并乘以numberBit的key为十的值，然后加上numberMap的key为一 的值，即9*10+1=91
         *       十一                               同上10+1=11
         *       一百万                          先取出numberMap为一的key的值，然后乘以numberBit的key为百的值，然后乘以numberBit的key为万的值，即1*100*10000=1000000
         *       一百八十八万           1*100+(8*10+8)*10000=100+88*10000=1880000
         *
         */
        long number = 0;//1008571
        String chinaNumberStr = "一千二百三十四万五千六百七十八";//12   叁佰贰十 320 三佰二十
        char[] arrNumber = chinaNumberStr.toCharArray();
        for (int i = 0; i < arrNumber.length; i++) {
            char num = arrNumber[i];
            if (i + 1 < arrNumber.length && numberBit.containsKey(arrNumber[i + 1])) {// 判断后面的汉字是否是位数(十百千万)
                if (numberMap.containsKey(num)) {// 如果当前的汉字不是位数

                    if(i + 3 < arrNumber.length&&arrNumber[i + 1]=='十'&&numberMap.containsKey(arrNumber[i + 2])){
                        number = number + Integer.parseInt(numberMap.get(num))* Integer.parseInt(numberBit.get(arrNumber[i + 1]));
                        number = number + Integer.parseInt(numberMap.get(arrNumber[i + 2]));
                        number = number * Integer.parseInt(numberBit.get(arrNumber[i + 3]));
                        i=i+2;
                    }else{// 取出当前对应的数字*位数对应倍数累加在number上
                        number = number + Integer.parseInt(numberMap.get(num))* Integer.parseInt(numberBit.get(arrNumber[i + 1]));
                    }
                } else if (numberBit.containsKey(num)) {// 如果当前的汉字是位数，即当前的汉字和后一个汉字都是位数(比如百万)
                    //则用number直接*后一个位数
                    number = number * Integer.parseInt(numberBit.get(arrNumber[i + 1]));
                }
            } else if (numberMap.containsKey(num)) {
                number = number + Integer.parseInt(numberMap.get(num));
            } else if (num == '十' && i == 0) {//“十”特殊处理 当出现十八之类的 十在前面的情况
                number = Integer.parseInt(numberBit.get('十'));
            }
        }
        System.out.println(number);
    }

    @Test
    public void test1(){
        long res = ch2Int("一百零五亿四千三百五十二万五千七百零三");
        System.out.println(res);
    }
    /**
     * 中文數字转阿拉伯数组【十万九千零六十  --> 109060】
     * @author 雪见烟寒
     * @param chineseNumber
     * @return
     */
    @SuppressWarnings("unused")
    public long ch2Int(String chineseNumber){
        long result = 0;
        int temp = 1;//存放一个单位的数字如：十万
        int count = 0;//判断是否有chArr
        char[] cnArr = new char[]{'一','二','三','四','五','六','七','八','九'};
        char[] chArr = new char[]{'十','百','千','万','亿'};
        for (int i = 0; i < chineseNumber.length(); i++) {
            boolean b = true;//判断是否是chArr
            char c = chineseNumber.charAt(i);
            for (int j = 0; j < cnArr.length; j++) {//非单位，即数字
                if (c == cnArr[j]) {
                    if(0 != count){//添加下一个单位之前，先把上一个单位值添加到结果中
                        result += temp;
                        temp = 1;
                        count = 0;
                    }
                    // 下标+1，就是对应的值
                    temp = j + 1;
                    b = false;
                    break;
                }
            }
            if(b){//单位{'十','百','千','万','亿'}
                for (int j = 0; j < chArr.length; j++) {
                    if (c == chArr[j]) {
                        switch (j) {
                            case 0:
                                temp *= 10;
                                break;
                            case 1:
                                temp *= 100;
                                break;
                            case 2:
                                temp *= 1000;
                                break;
                            case 3:
                                temp *= 10000;
                                break;
                            case 4:
                                temp *= 100000000;
                                break;
                            default:
                                break;
                        }
                        count++;
                    }
                }
            }
            if (i == chineseNumber.length() - 1) {//遍历到最后一个字符
                result += temp;
            }
        }
        return result;
    }
}
