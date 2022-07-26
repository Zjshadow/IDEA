package com.zjs.Exam;

import java.util.*;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/7/26 20:45
 **/
public class zy_7_26_T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> genes = new ArrayList<>();
        List<String> person = new ArrayList<>();

        int geneLen = in.nextInt();
        in.nextLine();
        while (geneLen-- > 0) {
            genes.add(in.nextLine());
        }
        int personLen = in.nextInt();
        in.nextLine();
        while (personLen-- > 0) {
            person.add(in.nextLine());
        }

        int isGene;
        for (int i = 0; i < person.size(); i++) {
            isGene = 0;
            for (int j = 0; j < genes.size(); j++) {
                if (person.get(i).contains(genes.get(j))) {
                    System.out.println("A new hero discovered");
                    isGene = 1;
                    break;
                }
            }

            if (isGene == 0) {
                System.out.println("Just an ordinary person");
            }
        }

    }
}
