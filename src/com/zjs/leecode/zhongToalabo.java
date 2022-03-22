package com.zjs.leecode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author lenovo
 * 中文数字转阿拉伯
 */
public class zhongToalabo {
    @Test
    public void test(){
        nummap = new HashMap<>();
        nummap.put('一',1L);nummap.put('二',2L);nummap.put('三',3L);
        nummap.put('四',4L);nummap.put('五',5L);nummap.put('六',6L);
        nummap.put('七',7L);nummap.put('八',8L);nummap.put('九',9L);
        map = new HashMap<>();
        map.put('十',10L);map.put('百',100L);map.put('千',1000L);map.put('万',10000L);
        map.put('亿',100000000L);

        String[] s1 = "一亿零五百零二亿一千二百三十四万一千零五".split("亿");
        long ans = 0L;
        for (int i = 0; i < s1.length; i++) {
            System.out.println(zhToala(s1[i].toCharArray()));
            ans += zhToala(s1[i].toCharArray())*Math.pow(100000000L,(s1.length-i-1));
        }
        System.out.println(ans);
    }
    HashMap<Character, Long> nummap;
    HashMap<Character, Long> map;
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
                    Character pop = stack.pop();
                    ans += nummap.get(pop)*map.get(nums[i]);
                }
                else {
                    //万
                    Character pop = stack.pop();
                    ans += nummap.get(pop);
                    ans *= map.get(nums[i]);
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
}
