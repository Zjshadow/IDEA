package com.zjs.leecode;

import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/6/24 21:52
 **/
public class lc207 {
    @Test
    public void test(){
        int num = 20;
        int [][] couse = new int[][] {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}};
        int num2 = 2;
        int [][] couse2 = new int[][] {{0,1},{1,0}};
        System.out.println(canFinish(num, couse));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0)
            return true;
        ConcurrentHashMap<Integer, Integer> hmReverse = new ConcurrentHashMap<>();
//        HashMap<Integer, Integer> hmReverse = new HashMap<>();
        for (int[] course : prerequisites) {
            hmReverse.put(course[0], course[1]);
        }

        while (!hmReverse.isEmpty()) {
            for(int key: hmReverse.keySet()) {
                int slow = key;
                int fast = key;
                while (hmReverse.containsKey(fast) && hmReverse.containsKey(hmReverse.get(fast))) {
                    slow = hmReverse.get(slow);
                    fast = hmReverse.get(hmReverse.get(fast));
                    // 成环则完不成
                    if (fast == slow)
                        return false;
                }
                slow = key;
                while (hmReverse.containsKey(slow)) {
                    int tmp = hmReverse.get(slow);
                    hmReverse.remove(slow);
                    slow = tmp;
                }
            }
        }

        return true;
    }
}

