package com.zjs.leecode;

import org.omg.PortableInterceptor.INACTIVE;

import java.beans.IntrospectionException;
import java.lang.reflect.Array;
import java.util.*;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/5/18 19:00
 **/
public class hw_5_18_T1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (input.hasNext()) {
            int num = input.nextInt();
            Map<Integer, ArrayList<Integer>> map = new HashMap<>();

            for (int i = 0; i < num; i++) {
                int flower = input.nextInt();
                int value = input.nextInt();

                ArrayList<Integer> temp = new ArrayList<>();
                if (map.containsKey(value)) {
                    temp = map.get(value);
                }

                temp.add(flower);
                map.put(value, temp);
            }

            ArrayList<Integer> idx4 = new ArrayList<>();
            ArrayList<Integer> idx2 = new ArrayList<>();
            ArrayList<Integer> idx1 = new ArrayList<>();

            for (Integer key : map.keySet()) {
                int len = map.get(key).size();
                if (len == 4) {
                    idx4.add(key);
                }else if (len == 3) {
                    idx1.add(key);
                    idx2.add(key);
                }else if (len == 2) {
                    idx2.add(key);
                }else {
                    idx1.add(key);
                }
            }

            Collections.sort(idx1);
            Collections.sort(idx2);
            Collections.sort(idx4);

            for (int i = 0; i < idx4.size(); i++) {
                ArrayList<Integer> f = map.get(idx4.get(i));
                Collections.sort(f);
                for (int j = 0; j < 4; j++) {
                    System.out.println(f.get(j) + " " + idx4.get(i));
                }
            }

            for (int i = 0; i < idx2.size(); i++) {
                ArrayList<Integer> f = map.get(idx2.get(i));
                Collections.sort(f);
                for (int j = 0; j < 2; j++) {
                    System.out.println(f.get(j) + " " + idx2.get(i));
                }
            }

            for (int i = 0; i < idx1.size(); i++) {
                ArrayList<Integer> f = map.get(idx1.get(i));
                Collections.sort(f);
                if (f.size() == 3) {
                    System.out.println(f.get(2) + " " + idx1.get(i));
                } else {
                    System.out.println(f.get(0) + " " + idx1.get(i));
                }
            }
        }

    }
}
